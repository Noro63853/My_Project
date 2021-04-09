package tests.bet_slip.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class OddsInBetSlipAfterReload extends BaseTest {
    @Test(description = "WB-134 : OK for bet-slip during reload")
    public void reloadThePage() {
        esportsPage.addOddsToBetSlip(3);
        webDriver().navigate().refresh();
        Assert.assertEquals(betSlipPage.gameCardsInBetSlip().size(), 3);
    }

}
