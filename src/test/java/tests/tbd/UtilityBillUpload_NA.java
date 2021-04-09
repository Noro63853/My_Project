package tests.tbd;

import org.testng.annotations.Test;
import tests.BaseTest;

public class UtilityBillUpload_NA extends BaseTest {

    @Test
    public void gggg() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Profile");
        profilePage.uploadUtilityBill();
    }

}
