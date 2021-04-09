package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Instagram extends BaseTest {
    @Test
    public void checkInstagram() {
        footer.selectSocialFooter("Instagram");
        mainPage.handleWindowByTitle("WINNERS Bet (@winnersbetgg) • Instagram photos and videos");
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://www.instagram.com/winnersbetgg/?igshid=16l8zqkoiosce");
    }

}
