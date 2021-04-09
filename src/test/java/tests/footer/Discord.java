package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Discord extends BaseTest {
    @Test
    public void checkDiscord() {
        footer.selectSocialFooter("Discord");
        mainPage.handleWindowByTitle("WIN Official");
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://discord.com/invite/Zb5GdzD");
    }

}
