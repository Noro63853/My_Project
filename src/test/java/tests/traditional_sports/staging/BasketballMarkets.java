package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BasketballMarkets extends BaseTest {

    @Test(description = "WB-53 : Basketball Markets filter")
    public void basketballMarket() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Basketball");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(), sportsPage.BASKETBALL_MARKETS);
        sportsPage.chooseMarketInFilter("Match Winner");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Match Result (Regular Time)");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Draw");
        Assert.assertEquals(sportsPage.getTheNameOfThirdOddOfRandomMatch(), "Away");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Total Points");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Over");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Under");
        sportsPage.openMarketFilter();
        sportsPage.chooseMarketInFilter("Points Handicap");
        Assert.assertEquals(sportsPage.getTheNameOfFirstOddOfRandomMatch(), "Home");
        Assert.assertEquals(sportsPage.getTheNameOfSecondOddOfRandomMatch(), "Away");

    }

}
