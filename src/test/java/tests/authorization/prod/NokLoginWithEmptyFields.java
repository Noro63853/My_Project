package tests.authorization.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokLoginWithEmptyFields extends BaseTest {

    @Test(description = "WB-5 : NOK for login with empty field")
    public void nokLoginWithEmptyFields() {
        headerPage.clickOnLogin();
        Assert.assertFalse(loginPage.isLoginButtonDisabled());
    }

}
