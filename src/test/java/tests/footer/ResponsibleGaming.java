package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class ResponsibleGaming extends BaseTest {
    @Test
    public void checkResponsibleGaming(){
        footer.selectItemInFooter("Responsible Gaming");
        softAssert.assertEquals(footer.getResponsibleGamingText(),jsonNode2.get("responsibleGaming").textValue());
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/responsible-gaming");
        softAssert.assertEquals(webDriver().getTitle(),"Read the Winners.bet responsibile gaming policy");
        softAssert.assertAll();
    }


}
