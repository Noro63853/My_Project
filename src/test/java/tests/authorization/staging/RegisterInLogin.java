package tests.authorization.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class RegisterInLogin extends BaseTest {

    @Test(description = "WB-2 : 'Register' button in 'Login' pop-up")
    public void registerInLogin() {
        headerPage.clickOnLogin();
        headerPage.clickOnSignUpButton();
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://win:w1nPorta2@bet.priotix.xyz/esports/home/matches?action=registration");
    }

}
