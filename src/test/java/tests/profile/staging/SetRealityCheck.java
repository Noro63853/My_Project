package tests.profile.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SetRealityCheck extends BaseTest {

    @Test
    public void setRealityCheck() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Responsible Gaming");
        profilePage.chooseRealityCheckOptions("10 minutes");
        profilePage.clickOnSetLimitButtonBySectionName("Reality Check");
        Assert.assertEquals(profilePage.getSuccessMessage(),"You have successfully set up a reality check message every 30 minutes");
        Assert.assertTrue(profilePage.isRealityCheckVisible());
        profilePage.chooseStay();
        Assert.assertFalse(profilePage.isRealityCheckVisible());
    }

}
