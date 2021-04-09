package tests.tbd;

import org.testng.annotations.Test;
import tests.BaseTest;

public class MatchCountForTheEsport extends BaseTest {
    @Test
    public void CheckMatchCountForEsports() throws InterruptedException {
        esportsPage.openEsport("LoL");
        esportsPage.showAllMatches();
        Thread.sleep(3000);
    }
}
