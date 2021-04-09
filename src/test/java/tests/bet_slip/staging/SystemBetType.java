package tests.bet_slip.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SystemBetType extends BaseTest {

    @Test(description = "WB-21 : OK for system bet type,  WB-82 : Options For system bet type")
    public void systemBetType() {
        esportsPage.addOddsToBetSlip(3);
        betSlipPage.selectBetTypeTo("System");
        Assert.assertEquals(betSlipPage.getOptionDropDown(),"2/3 3 opt.");
    }

}
