package tests.authorization.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class OkForForgotPassword extends BaseTest {

    @Test(description = "WB-3 : Ok for 'Forgot Password'")
    public void okForForgotPassword(){
        headerPage.clickOnLogin();
        loginPage.clickOnForgotPassword();
        Assert.assertEquals(loginPage.getSendButtonNameInForgot(),loginPage.THE_FIRST_NAME_OF_SEND_BUTTON_IN_FORGOT);
        Assert.assertFalse(loginPage.isSendButtonInForgotActive());
        loginPage.fillValueInForgotEmailField(jsonNode1.get("emailForForgotForStaging").textValue());
        loginPage.clickOnRecoveryLinkButton();
        Assert.assertEquals(loginPage.getSuccessMessageOfForgotPassword(),loginPage.SUCCESS_MESSAGE_FOR_FORGOT);
        Assert.assertEquals(loginPage.getSendButtonNameInForgot(),loginPage.THE_Second_NAME_OF_SEND_BUTTON_IN_FORGOT);
    }

}
