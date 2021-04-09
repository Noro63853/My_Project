package tests.tbd;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SignUp extends BaseTest {

    @Test(description = "WB-34 : OK for Registration")
    public void signUp() {
        headerPage.clickOnSignUpButton();
        signUpPage.register(signUpUser);
        Assert.assertEquals(signUpPage.getSuccessRegisterMessage(), signUpPage.SUCCESS_MESSAGE);
    }

}
