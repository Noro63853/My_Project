package tests.smoke.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ReloadInCasino extends BaseTest {

    @Test(description = "WB-127 : OK for reload button in casino page")
    public void reloadInCasino() {
        headerPage.selectTabInLeftHeader("Casino");
        casinoPage.get();
        casinoPage.clickOnProvider("Pragmatic Play");
        webDriver().navigate().refresh();
        casinoPage.get();
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/casino/THN");
    }

}
