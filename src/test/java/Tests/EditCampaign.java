package Tests;

import Pages.Campaign.CampaignDetails;
import Pages.Campaign.CampaignForm;
import Pages.Campaign.CampaignHome;
import Pages.Login;
import Pages.MainApp;
import Pages.NavigationTab;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by marcelo ferrufino on 8/24/2015.
 */
public class EditCampaign {
    private MainApp mainApp;
    private CampaignDetails campaignDetails;
    private CampaignHome campaignHome;

    private final String cpnName = "CampaignName01";

    private final String cpnNewName = "CampaignNameEdit";

    @BeforeClass
    public void setUp(){
        Login login = new Login()
                .setUserName()
                .setPassword();
        mainApp = login.clickLoginBtn();

        NavigationTab navigationTab = mainApp.goToNavigationTab();
        campaignHome = navigationTab.goToCampaignHome();
        CampaignForm campaignForm = campaignHome.clickNewBtn();
        campaignDetails = campaignForm.setCpnName(cpnName).clickSaveBtn();
    }

    @Test
    public void editCampaign(){
        CampaignDetails campaignDetails1 = campaignHome.selectRecentCpn(cpnName);
        CampaignForm campaignForm1 = campaignDetails1.clickEditBtn();
        campaignDetails1 = campaignForm1.setCpnName(cpnNewName).clickSaveBtn();
    }
}
