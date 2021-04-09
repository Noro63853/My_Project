package tests.bet_slip.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NokForBetTypes extends BaseTest {
    @Test(description = "WB-158 : NOK for bet types")
    public void checkBetTypes() {
        esportsPage.addOddsToBetSlip(1);
        betSlipPage.openBetTypeDropDown();
        Assert.assertTrue(betSlipPage.isBetTypeDisabled("Multiple"));
        Assert.assertTrue(betSlipPage.isBetTypeDisabled("System"));
        Assert.assertTrue(betSlipPage.isBetTypeDisabled("Chain"));
        betSlipPage.clearBetSlip();
        esportsPage.addOddsToBetSlip(2);
        betSlipPage.openBetTypeDropDown();
        Assert.assertTrue(betSlipPage.isBetTypeDisabled("System"));
    }

}
