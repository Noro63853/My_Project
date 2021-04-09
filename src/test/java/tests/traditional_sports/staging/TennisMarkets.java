package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TennisMarkets extends BaseTest {

    @Test(description = "WB-49 : Tennis Markets filter")
    public void checkTennisMarkets() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Tennis");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(), sportsPage.TENNIS_MARKETS);
        sportsPage.chooseMarketInFilter("Match Winner");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Total Games");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Over");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Under");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Game Handicap");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Sets Handicap");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Set Betting");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "2-0");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "2-1");
        Assert.assertEquals(sportsPage.getTheNameOfThirdOddOfRandomMatch(), "0-2");
        Assert.assertEquals(sportsPage.getTheNameOfFourthOddOfRandomMatch(), "1-2");
    }

}
