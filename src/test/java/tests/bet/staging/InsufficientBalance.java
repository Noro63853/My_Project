package tests.bet.staging;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class InsufficientBalance extends BaseTest {

    @Test(description = "WB-79 : NOK for bet with insufficient balance")
    public void betWithAmountMoreThanBalance(){
        headerPage.clickOnLogin();
        loginPage.login(loginUserForStaging);
        loginPage.clickOnLoginButtonInPopUp();
//        headerPage.goToHomePage();
        esportsPage.addOddsToBetSlip(2);
        betSlipPage.inputBetStake("12");
        Assert.assertEquals(betSlipPage.getErrorTextInBetSlip(),"Bet does not meet the requirements, please check and try again");
    }

}
