package Pages;

import Framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class Login {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String userName = "marcelofm@selenium.com";
    private final String password = "Control123";

    @FindBy(id = "username")
    @CacheLookup
    private WebElement userNameTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;

    public Login(){
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public Login setUserName(){
        wait.until(ExpectedConditions.visibilityOf(userNameTxt));
        userNameTxt.clear();
        userNameTxt.sendKeys(userName);
        return this;
    }

    public Login setPassword(){
        wait.until(ExpectedConditions.visibilityOf(passwordTxt));
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public MainApp clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return new MainApp(driver);
    }
}
