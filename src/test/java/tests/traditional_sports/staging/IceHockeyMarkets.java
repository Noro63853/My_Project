package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class IceHockeyMarkets extends BaseTest {

    @Test(description = "WB-43 : Football Markets filter")
    public void checkIceHockeyMarket() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Ice Hockey");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(),sportsPage.ICE_HOCKEY_MARKETS);
        sportsPage.chooseMarketInFilter("Match Winner");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Match Result (regular time)");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Draw");
        Assert.assertEquals(sportsPage.getTheNameOfThirdOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Total Goals");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Over");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Under");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Goals Handicap");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
    }

}
