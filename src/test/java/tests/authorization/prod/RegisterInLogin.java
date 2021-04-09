package tests.authorization.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class RegisterInLogin extends BaseTest {

    @Test(description = "WB-2 : 'Register' button in 'Login' pop-up")
    public void registerInLogin() {
        headerPage.clickOnLogin();
        headerPage.clickOnSignUpButton();
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://winners.bet/esports/home/matches?action=registration");
    }

}
