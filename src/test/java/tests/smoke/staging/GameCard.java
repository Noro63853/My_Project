package tests.smoke.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class GameCard extends BaseTest {

    @Test(description = "WB-138 : Game card in bet-slip")
    public void checkFirstEsportsGameCard() {
        Assert.assertEquals(esportsPage.getTeamsFromFirstEsportsGameCard(), esportsPage.getTeamsFromFirstEsportsGameBackground());
    }

}
