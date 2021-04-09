package tests.bet_slip.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SingleBets extends BaseTest {

    @Test(description = "WB-166 : OK for bet stake field with single bet type,  WB-140 : OK for bet amount express to single,  WB-19 : OK for single bet type with more than 1 market ,  WB-151 : NOK for bet amount field,  WB-23 : OK for 'Clear' in bet-slip ")
    public void singleBetFields(){
        esportsPage.addOddsToBetSlip(3);
        betSlipPage.inputBetStake("5");
        betSlipPage.clickOnBetTypeDropDown();
        betSlipPage.selectBetTypeTo("Single");
        Assert.assertEquals(betSlipPage.countOfSingleBetFields().size(),3);
        Assert.assertEquals(betSlipPage.getBetStakeField(),"");
        betSlipPage.inputBetStake("hjkjh");
        Assert.assertEquals(betSlipPage.getBetStakeField(),"");
    }

}
