package tests.authorization.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class OkForBalance extends BaseTest {

    @Test(description = "WB-181 : OK for Balance")
    public void okForBalance() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnShowBalanceButton();
        Assert.assertEquals(profilePage.getBalanceAmount(), jsonNode1.get("userBalanceForStaging").textValue());
    }
}
