package Pages.Campaign;

import Framework.WebDriverManager;
import Pages.BasePages.DetailsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CampaignDetails extends DetailsBase{

    public CampaignDetails(WebDriver driver){
        super.driver = driver;
        super.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    @Override
    public CampaignForm clickEditBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
        return new CampaignForm(driver);
    }

}
