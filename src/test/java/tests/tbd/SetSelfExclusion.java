package tests.tbd;

import org.testng.annotations.Test;
import tests.BaseTest;

public class SetSelfExclusion extends BaseTest {

    @Test
    public void setSelfExclusion() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Responsible Gaming");
        profilePage.chooseSelfExclusionOption("1 Week");
//        profilePage.clickOnSetLimitButtonBySectionName("Self-Exclusion");
//        headerPage.clickOnLogin();
//        Assert.assertEquals(webDriver().getCurrentUrl(),"https://win:w1nPorta2@bet.priotix.xyz/esports/home/matches?action=signIn");
    }

}
