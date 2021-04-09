package tests.authorization.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokForLogin extends BaseTest {

    @Test(description = "WB-4 : NOK for 'Login'")
    public void nokLogin() {
        headerPage.clickOnLogin();
        loginPage.login(nokLoginUser);
        loginPage.clickOnLoginButtonAndPopupNotClosed();
        Assert.assertEquals(loginPage.getErrorMessage(), loginPage.ERROR_TEXT);
    }
}
