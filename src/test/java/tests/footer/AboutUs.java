package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class AboutUs extends BaseTest {

    @Test
    public void checkAboutUs(){
        footer.selectItemInFooter("About Us");
        softAssert.assertEquals(footer.getAboutUsText(),jsonNode2.get("aboutUs").textValue());
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/about");
        softAssert.assertEquals(webDriver().getTitle(),"Read about Winners.bet");
        softAssert.assertAll();
    }

}
