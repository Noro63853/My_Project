package tests.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class GamblingTherapy extends BaseTest {
    @Test(description = "WB-99 : OK for the partner GLUECKSFALL")
    public void selectGamblingTherapyPartner(){
        footer.selectPartnerInFooter("GamblingTherapy");
        mainPage.handleWindowByTitle("Gambling Therapy – Gambling Therapy");
        Assert.assertEquals(webDriver().getCurrentUrl(),"https://www.gamblingtherapy.org/");
    }

}
