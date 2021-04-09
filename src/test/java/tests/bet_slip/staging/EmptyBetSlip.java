package tests.bet_slip.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class EmptyBetSlip extends BaseTest {

    @Test(description = "WB-163 : OK for empty bet-slip")
    public void checkEmptyBetSlip() {

        betSlipPage.openBetSlip();
        Assert.assertEquals(betSlipPage.checkBetSlip(), betSlipPage.OPENED_BET_SLIP_CLASS);
    }
}
