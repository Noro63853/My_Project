package tests.profile.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SetTimeOutLimit extends BaseTest {

    @Test
    public void setTimeOutLimitLimit()  {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        profilePage.openTabFromAvatar("Responsible Gaming");
        profilePage.clickOnFullNameInAvatar();
        profilePage.chooseTimeOutOption("1 Day");
        profilePage.clickOnSetLimitButtonBySectionName("Timeout Limit");
        Assert.assertEquals(profilePage.getSuccessMessage(),"Timeout limit setting successful. Please note that you will not be able to deposit or bet until the end of your timeout limit.");
    }

}
