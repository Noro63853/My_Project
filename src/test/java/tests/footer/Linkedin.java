package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Linkedin extends BaseTest {
    @Test
    public void checkLinkedin() {
        footer.selectSocialFooter("Linkedin");
        mainPage.handleWindowByTitle("Sign Up | LinkedIn");
        Assert.assertTrue(webDriver().getCurrentUrl().contains("https://www.linkedin.com"));
    }

}
