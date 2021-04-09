package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class PrivacyPolicy extends BaseTest {
    @Test
    public void checkPrivacyPolicy(){
        footer.selectItemInFooter("Privacy Policy");
        softAssert.assertEquals(footer.getPrivacyPolicyText(),jsonNode2.get("privacyPolicy").textValue());
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/privacy-policy");
        softAssert.assertEquals(webDriver().getTitle(),"Read the Winners.bet privacy policy");
        softAssert.assertAll();
    }

}
