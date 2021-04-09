package tests.general.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BackFromTournamentPage extends BaseTest {

    @Test(description = "WB-128 : OK for 'Tournaments' in home page")
    public void backFromTournament(){
        esportsPage.goToTabFromSecNav("Tournaments");
        esportsPage.goToTheTournamentPage(0);
        esportsPage.goBackFromTournamentPage();
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/esports/home/tournaments");
    }

}
