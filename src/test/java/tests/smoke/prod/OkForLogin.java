package tests.smoke.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class OkForLogin extends BaseTest {

    @Test(description = "WB-1 : Ok for Login")
    public void login() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForProd);
        Assert.assertEquals(profilePage.getUserName(), profilePage.FULL_NAME_IN_AVATAR_FOR_STAGING);

    }
}
