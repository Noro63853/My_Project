package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class NokPayments extends BaseTest {
    @Test(description = "WB-97 : NOK for payments in footer")
    public void selectPayment(){
        footer.selectVisaPaymentInFooter();
        softAssert.assertTrue(loginPage.isLoginPopUpVisible());
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/esports/home/matches?action=signIn");
        softAssert.assertAll();
    }

}
