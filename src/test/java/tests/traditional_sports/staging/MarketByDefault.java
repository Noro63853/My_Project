package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class MarketByDefault extends BaseTest {

    @Test
    public void marketByDefault() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Football");
        sportsPage.chooseMarketInFilter("Total Goals");
        sportsPage.openSportFromLeftMenu("Basketball");
        Assert.assertEquals(sportsPage.getSelectedMarket(),"Match Winner");
    }

}
