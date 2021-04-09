package tests.esports.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class EsportsTournaments extends BaseTest {

    @Test
    public void checkTournamentsPage() {
        esportsPage.selectEsportFromLeftMenu("LoL");
        esportsPage.goToTabFromSecNav("Tournaments");
        Assert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/esports/LeagueOfLegends/tournaments");
        String tournamentName = esportsPage.getTournamentNameByIndex(0);
        esportsPage.getTournamentNameByIndex(0);
        esportsPage.goToTheTournamentPage(0);
        Assert.assertEquals(esportsPage.getTournamentName(), tournamentName.toUpperCase());
    }
}
