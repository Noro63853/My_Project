package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class GluecksFall extends BaseTest {
    @Test(description = "WB-99 : OK for the partner GLUECKSFALL")
    public void selectTheGluecksfall(){
        footer.selectPartnerInFooter("Gluecksfall");
        mainPage.handleWindowByTitle("Home - GLUECKSFALL");
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://gluecksfall.com/en/");
    }

}
