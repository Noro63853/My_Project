package tests.general.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BrowserBackButton extends BaseTest {

    @Test(description = "WB-126 : OK for browser Back button")
    public void clickOnBackButton() {
        headerPage.selectTabInLeftHeader("Casino");
//        webDriver().navigate().back();
        casinoPage.goBackFromCasinoPage();
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://win:w1nPorta2@bet.priotix.xyz/esports/home/matches");
    }
}
