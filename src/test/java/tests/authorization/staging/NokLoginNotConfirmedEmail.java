package tests.authorization.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokLoginNotConfirmedEmail extends BaseTest {

    @Test(description = "WB-129 : NOK for login with not confirmed email")
    public void nokLoginWithNotConfirmedUser() {
        headerPage.clickOnLogin();
        loginPage.login(notConfirmedLoginUserForStaging);
        loginPage.clickOnForgotPassword();
        Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your email");
    }

}
