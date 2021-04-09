package tests.authorization.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokForForgotPassword extends BaseTest {

    @Test(description = "WB-130 : NOK for 'Forgot Password' with not registered email")
    public void nokForForgotPassword() {
        headerPage.clickOnLogin();
        loginPage.clickOnForgotPassword();
        loginPage.fillValueInForgotEmailField(loginPage.INVALID_EMAIL_FOR_FORGOT);
        Assert.assertEquals(loginPage.getErrorMessageOfForgotPassword(), loginPage.NOT_REGISTERED_EMAIL_MESSAGE_FOR_FORGOT);
    }

}
