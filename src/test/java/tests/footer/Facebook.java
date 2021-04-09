package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Facebook extends BaseTest {

    @Test
    public void checkFacebook() {
        footer.selectSocialFooter("Facebook");
        mainPage.handleWindowByTitle("Winners Bet - Home | Facebook");
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://www.facebook.com/WINNERSBETGG/");
    }

}
