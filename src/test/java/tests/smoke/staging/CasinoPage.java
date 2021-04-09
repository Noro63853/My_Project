package tests.smoke.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CasinoPage extends BaseTest {

    @Test(description = "WB-13 : OK for casino section ")
    public void casinoPageTest() {
        headerPage.selectTabInLeftHeader("Casino");
        casinoPage.get();
        Assert.assertEquals(webDriver().getTitle(), casinoPage.TITLE);
        Assert.assertEquals(casinoPage.getProvidersInCasino(), casinoPage.casinoProvidersStaging);
    }

}
