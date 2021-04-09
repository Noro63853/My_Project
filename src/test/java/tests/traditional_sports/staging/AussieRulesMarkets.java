package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class AussieRulesMarkets extends BaseTest {

    @Test(description = "WB-43 : Football Markets filter")
    public void footballMarket() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openAllSports();
        sportsPage.openSportFromLeftMenu("Aussie Rules");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(),sportsPage.AUSSIE_RULES_MARKETS);
    }

}
