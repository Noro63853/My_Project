package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class Promotions extends BaseTest {

    @Test
    public void checkPromotions() {
        footer.selectItemInFooter("Promotions");
        mainPage.waitToTitleContains("Esports betting bonuses!");
        softAssert.assertEquals(webDriver().getTitle(), promotionsPage.TITLE);
        softAssert.assertEquals(webDriver().getCurrentUrl(), baseUrl + "/promotions");
        softAssert.assertAll();
    }

}
