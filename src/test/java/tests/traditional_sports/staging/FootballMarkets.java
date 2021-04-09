package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FootballMarkets extends BaseTest {

    @Test(description = "WB-43 : Football Markets filter")
    public void footballMarket() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Football");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(), sportsPage.FOOTBALL_MARKETS);
        sportsPage.chooseMarketInFilter("Match Result");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Draw");
        Assert.assertEquals(sportsPage.getTheNameOfThirdOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Total Goals");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Over");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Under");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Both Teams To Score");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Yes");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "No");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("1st Half Result");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Draw");
        Assert.assertEquals(sportsPage.getTheNameOfThirdOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Double Chance");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home/ Draw");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Home/ Away");
        Assert.assertEquals(sportsPage.getTheNameOfThirdOddOfRandomMatch(), "Away/ Draw");

    }

}
