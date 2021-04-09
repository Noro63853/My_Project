package tests.authorization.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokForgotPassword extends BaseTest {

    @Test(description = "WB-130 : NOK for 'Forgot Password' with not registered email")
    public void nokForForgotPassword(){
        headerPage.clickOnLogin();
        loginPage.clickOnForgotPassword();
        loginPage.fillValueOnEmailField("fngo@mailinator.com");
        loginPage.clickOnRecoveryLinkButton();
        Assert.assertEquals(loginPage.getErrorMessageOfForgotPassword(),loginPage.NOT_REGISTERED_EMAIL_MESSAGE_FOR_FORGOT);
    }


}
