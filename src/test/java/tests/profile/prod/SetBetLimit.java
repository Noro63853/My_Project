package tests.profile.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SetBetLimit extends BaseTest {

    @Test
    public void setBetLimit() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForProd);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Responsible Gaming");
        profilePage.clickOnSetLimitButtonBySectionName("Bet Limits");
        Assert.assertEquals(profilePage.getSuccessMessage(), "Limit successfully updated.");
    }

}
