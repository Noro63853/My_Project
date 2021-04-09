package tests.smoke.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SportPage extends BaseTest {

    @Test(description = "WB-16 : OK for sport list")
    public void okForSportPage() {
        headerPage.selectTabInLeftHeader("Sports");
        Assert.assertEquals(webDriver().getTitle(), sportsPage.TITLE);
        Assert.assertEquals(sportsPage.sportItems, sportsPage.getSportItems());
    }

}
