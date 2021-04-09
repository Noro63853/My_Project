package tests.smoke.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ReloadInCasino extends BaseTest {


    @Test(description = "WB-127 : OK for reload button in casino page")
    public void reloadInCasino()  {
        headerPage.selectTabInLeftHeader("Casino");
        casinoPage.clickOnPragmatic();
        webDriver().navigate().refresh();
//        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/casino/TPG");
    }

}
