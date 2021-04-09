package tests.profile.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TransactionsHistory extends BaseTest {

    @Test
    public void goToTransactionsHistory() {
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
        profilePage.clickOnFullNameInAvatar();
        profilePage.openTabFromAvatar("Transactions History");
        Assert.assertTrue(profilePage.isDatePickerVisible());
        Assert.assertEquals(profilePage.getListOfStatuses(),profilePage.TRANSACTIONS_LIST);

    }

}
