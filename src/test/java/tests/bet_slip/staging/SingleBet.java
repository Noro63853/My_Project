package tests.bet_slip.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SingleBet extends BaseTest {

    @Test(description = "WB-19 : OK for single bet type with more than 1 market,  WB-17 : OK for Coefficient in bets-slip ")
    public void singleBet(){
        esportsPage.addOddsToBetSlip(1);
        Assert.assertEquals(betSlipPage.getBetType(), "Single");
    }

}
