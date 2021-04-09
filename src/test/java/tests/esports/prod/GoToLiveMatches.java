package tests.esports.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class GoToLiveMatches extends BaseTest {

    @Test(description = "WB-108 : OK for go to live matches")
    public void goToLiveMatchesFromSport() {
        esportsPage.goEsportByGameCount("0");
        Assert.assertEquals(esportsPage.getTextFromEsportWithoutGame(),esportsPage.NO_GAMES_TEXT);
        esportsPage.goToLiveMatches();
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/esports/live/matches");

    }
}
