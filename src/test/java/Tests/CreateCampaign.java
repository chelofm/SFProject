package Tests;

import Framework.WebDriverManager;
import Pages.Campaign.CampaignDetails;
import Pages.Campaign.CampaignForm;
import Pages.Campaign.CampaignHome;
import Pages.Login;
import Pages.MainApp;
import Pages.NavigationTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/22/2015.
 */
public class CreateCampaign {
    private MainApp mainApp;

    private final String cpnName = "CampaignName01";
    private final String type = "Partners";
    private final String status = "Completed";
    private final String startDate = "10/08/2015";
    private final String endDate = "15/08/2015";
    private final String expectedRevenue = "100.25";
    private final String budgetedCost = "15000";
    private final String actualCost = "13000";
    private final String expectedResponse = "10";
    private final String numSet = "100";
    private final String description = "description of new " + cpnName;

    @BeforeClass
    public void setUp(){
        Login login = new Login()
                            .setUserName()
                            .setPassword();
        mainApp = login.clickLoginBtn();
    }

    @Test
    public void createCampaign(){
        NavigationTab navigationTab = mainApp.goToNavigationTab();
        CampaignHome campaignHome = navigationTab.goToCampaignHome();
        CampaignForm campaignForm = campaignHome.clickNewBtn();
        CampaignDetails campaignDetails = campaignForm.setCpnName(cpnName)
                .checkActive()
                .selectType(type)
                .selectStatus(status)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setExpectedRevenue(expectedRevenue)
                .setBudgetedCost(budgetedCost)
                .setActualCost(actualCost)
                .setExpectedResponse(expectedResponse)
                .setNumSet(numSet)
                .setDescription(description)
                .clickSaveBtn();

        Assert.assertEquals(campaignDetails.getCampaignName(), cpnName);
        Assert.assertTrue(campaignDetails.getActiveStatus());
        Assert.assertEquals(campaignDetails.getType(), type);
        Assert.assertEquals(campaignDetails.getStatus(), status);
        Assert.assertEquals(campaignDetails.getStartDate(), startDate);
        Assert.assertEquals(campaignDetails.getEndDate(), endDate);
        Assert.assertEquals(campaignDetails.getExpectedRevenue(), expectedRevenue);
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().getDriver().close();
    }
}
