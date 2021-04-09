package tests.authorization.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokForSignUp extends BaseTest {

    @Test(description = "WB-35 : NOK for Registration")
    public void nokSignUp() {
        headerPage.clickOnSignUpButton();
        signUpPage.fillAllFieldsInStep1(nokSignUpUser);
        Assert.assertEquals(signUpPage.invalidEmailError(), signUpPage.EMAIL_ERROR_MESSAGE);
    }

}
