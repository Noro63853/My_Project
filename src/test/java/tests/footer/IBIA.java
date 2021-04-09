package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class IBIA extends BaseTest {
    @Test(description = "WB-99 : OK for the partner GLUECKSFALL")
    public void selectTheIBIAPartner(){
        footer.selectPartnerInFooter("Ibia");
        mainPage.handleWindowByTitle("Homepage new | IBIA");
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://ibia.bet/");
    }

}
