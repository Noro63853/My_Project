package tests.traditional_sports.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class RugbyUnionMarkets extends BaseTest {

    @Test(description = "WB-43 : Football Markets filter")
    public void rugbyUnion() {
//        headerPage.goHomeFromLandingPage();
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openSportFromLeftMenu("Rugby Union");
        sportsPage.clickOnDateFilter();
        Assert.assertEquals(sportsPage.getDatesFromDateFilter(),sportsPage.DATES_IN_FILTER);
        sportsPage.openMarketFilter();
        Assert.assertEquals(sportsPage.getMarkets(),sportsPage.RUGBY_UNION_MARKETS);
    }

}
