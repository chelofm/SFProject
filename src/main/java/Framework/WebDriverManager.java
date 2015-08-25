package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class WebDriverManager {
    private static WebDriverManager instance;
    private WebDriver driver;
    private final String baseUrl = "https://login.salesforce.com";
    private WebDriverWait wait;
    private String browser = "Firefox";

    private final String mode = "Local"; //Local, Remote
    private final String sauceUser = "";
    private final String sauceAccessKey = "";


    private WebDriverManager(){
        initializeWebDriver();
    }

    public static WebDriverManager getInstance(){
        if ( instance == null ){
            instance = new WebDriverManager();
        }
        return instance;
    }

    private void initializeWebDriver(){
        if ( mode.equalsIgnoreCase("Local")){
            if ( browser.equalsIgnoreCase("Firefox") ){
                driver = new FirefoxDriver();
            }else if ( browser.equalsIgnoreCase("Chrome")){
                driver = new ChromeDriver();
            }
        }else if ( mode.equalsIgnoreCase("Remote") ){

            // Choose the browser, version, and platform to test
            DesiredCapabilities caps = DesiredCapabilities.safari();
            caps.setCapability("platform", "OS X 10.11");
            caps.setCapability("version", "8.1");
            // Create the connection to Sauce Labs to run the tests
            try {
                this.driver = new RemoteWebDriver(
                        new URL("http://" + sauceUser + ":" + sauceAccessKey + "@ondemand.saucelabs.com:80/wd/hub"),
                        caps);
            } catch (MalformedURLException e) {
                // implement
            }

        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
