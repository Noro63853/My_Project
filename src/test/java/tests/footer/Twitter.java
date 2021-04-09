package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Twitter extends BaseTest {

    @Test
    public void checkTwitter() {
        footer.selectSocialFooter("Twiter");
        mainPage.handleWindowByTitle("Profile / Twitter");
//        footer.goToSecondWindow();
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://twitter.com/WinnersBetGG");
    }

}
