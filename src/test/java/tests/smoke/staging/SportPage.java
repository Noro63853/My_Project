package tests.smoke.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SportPage extends BaseTest {

    @Test(description = "WB-16 : OK for sport list")
    public void okForSportPage() {
        headerPage.selectTabInLeftHeader("Sports");
        sportsPage.openAllSports();
        Assert.assertEquals(webDriver().getTitle(), sportsPage.TITLE);
//        Assert.assertEquals(sportsPage.sportItems, sportsPage.getSportItems());
        System.out.println(sportsPage.getSportItems());
    }

}
