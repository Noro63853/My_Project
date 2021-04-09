package tests.smoke.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class PromotionsPage extends BaseTest {
    @Test(description = "WB-14 : OK for promotions")
    public void promotionsPageTest() {
        headerPage.selectTabInLeftHeader("Promotions");
        promotionsPage.get();
        Assert.assertEquals(webDriver().getTitle(), promotionsPage.TITLE);
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/promotions");
    }

}
