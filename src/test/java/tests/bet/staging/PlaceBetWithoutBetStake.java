package tests.bet.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class PlaceBetWithoutBetStake extends BaseTest {

    @Test(description = "WB-81 : NOK for bet with empty bet amount ")
    public void placeBet() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        esportsPage.addOddsToBetSlip(2);
        Assert.assertEquals(betSlipPage.getPlaceBetButtonClass(), "placeBetButton disabled");
    }

}
