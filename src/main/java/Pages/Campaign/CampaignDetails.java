package Pages.Campaign;

import Framework.Helper;
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

    @FindBy(id = "cpn1_ileinner")
    @CacheLookup
    private WebElement cpnNameContainer;

    @FindBy(id = "cpn16_chkbox")
    @CacheLookup
    private WebElement activeContainer;

    @FindBy(id = "cpn2_ileinner")
    @CacheLookup
    private WebElement typeContainer;

    @FindBy(id = "cpn3_ileinner")
    @CacheLookup
    private WebElement statusContainer;

    @FindBy(id = "cpn5_ileinner")
    @CacheLookup
    private WebElement startDateContainer;

    @FindBy(id = "cpn6_ileinner")
    @CacheLookup
    private WebElement endDateContainer;

    @FindBy(id = "cpn8_ileinner")
    @CacheLookup
    private WebElement expectedRevenueContainer;

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

    public String getCampaignName(){
        String campaignName;

        wait.until(ExpectedConditions.visibilityOf(cpnNameContainer));
        campaignName = cpnNameContainer.getText();
        return campaignName.replace("[View Hierarchy]", "").trim();
    }

    public boolean getActiveStatus(){
        boolean status = false;

        wait.until(ExpectedConditions.visibilityOf(activeContainer));
        if ( activeContainer.getAttribute("title").equalsIgnoreCase("Checked") ){
            status = true;
        }
        return status;
    }

    public String getType(){
        wait.until(ExpectedConditions.visibilityOf(typeContainer));
        return typeContainer.getText();
    }

    public String getStatus(){
        wait.until(ExpectedConditions.visibilityOf(statusContainer));
        return statusContainer.getText();
    }

    public String getStartDate(){
        wait.until(ExpectedConditions.visibilityOf(startDateContainer));
        return startDateContainer.getText();
    }

    public String getEndDate(){
        wait.until(ExpectedConditions.visibilityOf(endDateContainer));
        return endDateContainer.getText();
    }

    public String getExpectedRevenue(){
        wait.until(ExpectedConditions.visibilityOf(expectedRevenueContainer));
        return Helper.addDolarCharToString(expectedRevenueContainer.getText());
    }

}
