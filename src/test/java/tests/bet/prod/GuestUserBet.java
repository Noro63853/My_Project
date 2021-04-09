package tests.bet.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class GuestUserBet extends BaseTest {

    @Test(description = "WB-78 : NOK for bet with guest user")
    public void checkBetForGuestUser() {
        esportsPage.addOddsToBetSlip(3);
        Assert.assertEquals(betSlipPage.getPlaceBetButtonName(), "SIGN IN TO BET");
        betSlipPage.placeBet();
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://winners.bet/esports/home/matches?action=signIn");
    }

}
