package tests.profile.staging;

import org.testng.annotations.Test;
import tests.BaseTest;

public class ChangeData extends BaseTest {

    @Test
    public void changeData() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Profile");
        profilePage.changeData("Erevan");
        profilePage.inputPasswordInProfile(jsonNode1.get("validPassword").textValue());
        profilePage.clickOnSaveDetails();
    }

}
