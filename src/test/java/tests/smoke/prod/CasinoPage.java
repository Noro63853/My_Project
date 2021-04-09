package tests.smoke.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CasinoPage extends BaseTest {

    @Test(description = "WB-13 : OK for casino section ")
    public void casinoPageTest() {
        headerPage.selectTabInLeftHeader("Casino");
        Assert.assertEquals(webDriver().getTitle(), casinoPage.TITLE);
        Assert.assertEquals(casinoPage.casinoProvidersProd, casinoPage.getProvidersInCasino());
    }

}
