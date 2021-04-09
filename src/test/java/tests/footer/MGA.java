package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class MGA extends BaseTest {
    @Test(description = "WB-99 : OK for the partner GLUECKSFALL")
    public void selectTheFifthPartner(){

        footer.selectPartnerInFooter("MGA");
        mainPage.switchToNewWindow();
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://www.authorisation.mga.org.mt/verification.aspx?company=49c32db3-fcca-45b6-af32-ec698f189c0f");
    }

}
