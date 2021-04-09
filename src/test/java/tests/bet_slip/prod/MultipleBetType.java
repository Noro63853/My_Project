package tests.bet_slip.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class MultipleBetType extends BaseTest {

    @Test(description = "WB-20 : OK for multiple bet type")
    public void multipleType(){
        esportsPage.addOddsToBetSlip(3);
        Assert.assertEquals(betSlipPage.getBetType(),"Multiple");
    }


}
