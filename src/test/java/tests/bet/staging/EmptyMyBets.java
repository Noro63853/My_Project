package tests.bet.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class EmptyMyBets extends BaseTest {

    @Test(description = "WB-159 : Empty My Bets ")
    public void checkMyBets() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        betSlipPage.openMyBets();
        Assert.assertEquals(betSlipPage.getTextOfNoBets(), "No pending bets available.");
    }
}
