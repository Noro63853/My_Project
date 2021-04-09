package tests.bet_slip.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ChainBetType extends BaseTest {

    @Test(description = "WB-22 : OK for Chain bet type ")
    public void chainBetType() {

        esportsPage.addOddsToBetSlip(3);
        betSlipPage.clickOnBetTypeDropDown();
        betSlipPage.selectBetTypeTo("Chain");
        Assert.assertEquals(3, betSlipPage.countOfDragIcons().size());
    }

}
