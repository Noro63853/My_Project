package tests.tbd;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class UserInactivity extends BaseTest {

    @Test(description = "WB-167 : NOK for user activity")
    public void checkPageAfter30Minutes() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForProd);
        Assert.assertFalse(profilePage.isProfileAvailable());
    }
}
