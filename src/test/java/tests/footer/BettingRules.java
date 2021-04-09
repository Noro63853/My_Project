package tests.footer;

import org.testng.annotations.Test;
import tests.BaseTest;

public class BettingRules extends BaseTest {

    @Test
    public void checkBettingRules(){
        footer.selectItemInFooter("Betting Rules");
        softAssert.assertEquals(footer.getBettingRulesText(),jsonNode2.get("bettingRules").textValue());
        softAssert.assertEquals(webDriver().getTitle(),"Winners.bet betting rules");
        softAssert.assertEquals(webDriver().getCurrentUrl(),baseUrl + "/betting-rules");
        softAssert.assertAll();
    }

}
