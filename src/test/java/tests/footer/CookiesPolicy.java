package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CookiesPolicy extends BaseTest {

    @Test
    public void checkCookiesPolicy(){
        footer.selectItemInFooter("Cookie Policy");
        softAssert.assertEquals(footer.getCookiesPolicyText(),jsonNode2.get("cookiePolicy").textValue());
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/cookie-policy");
        softAssert.assertEquals(webDriver().getTitle(),"Read the Winners.bet cookie policy");
        softAssert.assertAll();
    }

}
