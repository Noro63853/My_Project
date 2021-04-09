package tests.tbd;

import org.testng.annotations.Test;
import tests.BaseTest;

public class BonusInBalance_jk extends BaseTest {

    @Test(description = "WB-156 : OK for bonus")
    public void checkBonusAfterHover() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        profilePage.get();
        profilePage.hoverToBalance();
    }
}
