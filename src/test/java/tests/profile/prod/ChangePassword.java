package tests.profile.prod;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ChangePassword extends BaseTest {

    @Test
    public void changePassword() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForProd);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Profile");
        profilePage.changePassword(jsonNode1.get("validPassword").textValue(),"Test123@");
        Assert.assertEquals(profilePage.getSuccessMessage(),"You have successfully changed your password.");
    }

}
