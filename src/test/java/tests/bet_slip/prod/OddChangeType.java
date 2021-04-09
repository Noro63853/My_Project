package tests.bet_slip.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class OddChangeType extends BaseTest {

    @Test(description = "WB-24 : OK for 'Odd change type'")
    public void showOddChangeType() {
        betSlipPage.openBetSlip();
        betSlipPage.showSettings();
        Assert.assertEquals(betSlipPage.getSettingsText(), betSlipPage.OPENED_SETTINGS);
        Assert.assertEquals(betSlipPage.getNameOfOddChangeType(), "Always ask");
    }
}
