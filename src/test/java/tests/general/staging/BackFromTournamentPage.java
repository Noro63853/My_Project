package tests.general.staging;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BackFromTournamentPage extends BaseTest {
    @BeforeMethod
    public void goToTournamentPage  (){
        esportsPage.goToTabFromSecNav("Tournaments");
        esportsPage.goToTheTournamentPage(0);
    }

    @Test(description = "WB-128 : OK for 'Tournaments' in home page")
    public void backFromTournament(){
        esportsPage.goBackFromTournamentPage();
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/esports/home/tournaments");
    }

}
