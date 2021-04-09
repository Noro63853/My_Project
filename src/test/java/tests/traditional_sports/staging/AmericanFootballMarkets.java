package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class AmericanFootballMarkets extends BaseTest {

    @Test(description = "WB-43 : Football Markets filter")
    public void americanFootballMarket() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("American Football");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(),sportsPage.AMERICAN_FOOTBALL_MARKETS);
    }

}
