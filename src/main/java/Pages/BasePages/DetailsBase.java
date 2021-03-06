package Pages.BasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public abstract class DetailsBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "edit")
    @CacheLookup
    protected WebElement editBtn;


    public abstract Object clickEditBtn();
}
