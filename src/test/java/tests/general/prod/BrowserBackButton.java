package tests.general.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BrowserBackButton extends BaseTest {

    @Test(description = "WB-126 : OK for browser Back button")
    public void clickOnBackButton() {
        headerPage.selectTabInLeftHeader("Casino");
        webDriver().navigate().back();
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://winners.bet/esports/home/matches");
    }
}
