package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class TermsAndConditions extends BaseTest {
    @Test
    public void checkTermsAndConditions() {
        footer.selectItemInFooter("Terms & Conditions");
        softAssert.assertEquals(footer.getTermsAndConditionsText(), jsonNode2.get("termsAndConditions").textValue());
        softAssert.assertEquals(webDriver().getCurrentUrl(), baseUrl + "/terms-and-conditions");
        softAssert.assertEquals(webDriver().getTitle(), "Read the Winners.bet terms and conditions");
        softAssert.assertAll();
    }

}
