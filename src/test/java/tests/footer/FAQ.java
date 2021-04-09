package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class FAQ extends BaseTest {
    @Test
    public void checkFAQ()  {
        footer.selectItemInFooter("FAQ");
        softAssert.assertEquals(footer.getFAQText(),jsonNode2.get("faq").textValue());
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/faq");
        softAssert.assertEquals(webDriver().getTitle(),"Frequently asked questions - Winners.bet - Esports Betting");
        softAssert.assertAll();
    }

}
