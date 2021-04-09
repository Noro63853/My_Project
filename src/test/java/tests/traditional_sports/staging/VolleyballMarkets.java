package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VolleyballMarkets extends BaseTest {

    @Test(description = "WB-57 : Volleyball Markets filter")
    public void checkVolleyballMarkets() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Volleyball");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(),sportsPage.VOLLEYBALL_MARKETS);
        sportsPage.chooseMarketInFilter("Match Winner");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Total Points");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Over");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Under");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Total Sets");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Over");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Under");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Sets Handicap");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Points Handicap");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");


    }

}
