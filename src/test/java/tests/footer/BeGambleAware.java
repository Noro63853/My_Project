package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BeGambleAware extends BaseTest {

    @Test
    public void selectTheBeGambleAwarePartner() {
        footer.selectPartnerInFooter("Begambleaware");
        mainPage.handleWindowByTitle("BeGambleAware®: Gambling Help & Gambling Addiction | BeGambleAware");
        Assert.assertEquals(webDriver().getCurrentUrl(), "https://www.begambleaware.org/");
    }

}
