package tests.profile.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SetDepositLimit extends BaseTest {

    @Test
    public void setDepositLimit() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForProd);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Responsible Gaming");
        profilePage.inputDepositLimitAmount("1500");
        profilePage.clickOnSetLimitButtonBySectionName("Deposit Limit");
        Assert.assertEquals(profilePage.getSuccessMessage(),"Limit successfully updated.");
    }

}
