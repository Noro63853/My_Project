package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProfilePage extends BasePage {

//    public String FILE_PATH = "/home/norayr/code/tests-winners-bet/src/test/resources/API.odt";
    public final String FULL_NAME_IN_AVATAR_FOR_STAGING = "Nor" + System.lineSeparator() + "Anton";
//    public String FULL_NAME_IN_AVATAR_FOR_PROD = "PX" + System.lineSeparator() + "Test";
//    public String TITLE = "Winners.bet: Esports news, scores, stats, and schedules";
    public final String TRANSACTIONS_LIST = "Bet\n" +
            "Win\n" +
            "Return\n" +
            "Bonus\n" +
            "Bonus bet\n" +
            "Commission\n" +
            "Withdrawal\n" +
            "Manual correction up\n" +
            "Deposit\n" +
            "Withdrawal request\n" +
            "Submitted withdrawal\n" +
            "Rejected withdrawal\n" +
            "**Paid withdrawal\n" +
            "Processed\n" +
            "In recalculation\n" +
            "Wagering bonus\n" +
            "Pending bet\n" +
            "Manual correction down\n" +
            "All";
    public final String BET_HISTORY_STATUSES = "Pending\n" +
            "Lost\n" +
            "Returned\n" +
            "Won\n" +
            "CashedOut\n" +
            "All Statuses";


    @FindBy(xpath = "//div[@class='select-options']/div")
    List<WebElement> itemInAvatar;

    @FindBy(className = "RealityCheckContent")
    WebElement realityCheckPopUp;

    @FindBy(xpath = "//p[text() = 'Utility Bill or Bank Statement']//following-sibling::label")
    WebElement utilityBillUpload;

    @FindBy(className = "userName")
    WebElement fullNameInAvatar;

    @FindBy(className = "userBalance")
    WebElement showBalanceButtonElement;

    @FindBy(xpath = "//div[@class='userBalance']/div[1]")
    WebElement balance;

    @FindBy(xpath = "//div[text() = 'My Bets']")
    WebElement myBets;

//    @FindBy(xpath = "//div[@class='DepositLimit']//button")
//    WebElement depositLimit;
//
//    @FindBy(xpath = "//button[text()='set limit']")
//    WebElement betLimit;
//
//    @FindBy(xpath = "//div[@class='DepositLimit']//button")
//    WebElement timeOutLimit;
//
//    @FindBy(xpath = "//div[@class='DepositLimit']//button")
//    WebElement selfExclusion;
//
//    @FindBy(xpath = "//div[@class='DepositLimit']//button")
//    WebElement realityCheck;

    @FindBy(xpath = "")
    WebElement timeOutLimitDropDown;

    @FindBy(xpath = "//div[@class='DepositLimit tt-selfExclusion']//div[@class='select-content']")
    WebElement selfExclusionDropDown;

    @FindBy(xpath = "//div[@class='DepositLimit mb-45 tt-realityCheck']//div[@class='select-content']")
    WebElement realityCheckDropDown;

    @FindBy(className = "success")
    WebElement successMessage;

    @FindBy(name = "deposit_limit")
    WebElement depositLimitAmount;

//    @FindBy(name = "bet_limit")
//    WebElement betLimitAmount;

    @FindBy(xpath = "//div[@class='DepositLimit']//div[@class='select-option']")
    List<WebElement> timeOutOptions;

    @FindBy(xpath = "//div[@class='DepositLimit']//div[@class='select-option']")
    List<WebElement> selfExclusionOptions;

    @FindBy(xpath = "//div[@class='DepositLimit']//div[@class='select-option']")
    List<WebElement> realityCheckOptions;

    @FindBy(className = "stayButton")
    WebElement stayRealityCheck;

//    @FindBy(xpath = "//div[@class='activeFields']/div[@class='sharedInput']")
//    List<WebElement> changeableDataInProfile;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInProfile;

    @FindBy(xpath = "//button[contains(@class, 'mainButton') and text() = 'Save Details']")
    WebElement saveDetails;

    @FindBy(name = "address1")
    WebElement address1;

    @FindBy(name = "old_password")
    WebElement oldPasswordField;

    @FindBy(name = "new_password")
    WebElement newPasswordField;

    @FindBy(name = "confirmpassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//div[@class='changePassword']//button")
    WebElement changePssButton;

    @FindBy(className = "datePickerWrapper")
    WebElement datePickerInTransactionsHistory;

    @FindBy(xpath = "//div[@class='FilterBar']/div[@class='selectWrapper'][2]")
    WebElement transactionDropDown;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return fullNameInAvatar.getText();
    }

    public void hoverToBalance() {
//        hoverTo(userBalance);
    }

    public void openTabFromAvatar(String value) {
        for (WebElement element : itemInAvatar) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void clickOnFullNameInAvatar() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(fullNameInAvatar);
    }

    public String getListOfStatuses() {
        clickOnElement(transactionDropDown);
        return transactionDropDown.getText();
    }

    public void changeData(String newAddress1) {
        address1.clear();
        fillText(address1, newAddress1);
    }

    public boolean isProfileAvailable() {
        return fullNameInAvatar.isDisplayed();
    }

    public void clickOnSaveDetails() {
        clickOnElement(saveDetails);
    }

    public void inputPasswordInProfile(String value) {
        fillText(passwordInProfile, value);
    }

    public void chooseTimeOutOption(String value) {
        clickOnElement(timeOutLimitDropDown);
        for (WebElement element : timeOutOptions) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void chooseRealityCheckOptions(String value) {
        clickOnElement(realityCheckDropDown);
        for (WebElement element : realityCheckOptions) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    public void chooseSelfExclusionOption(String value) {
        clickOnElement(selfExclusionDropDown);
        for (WebElement element : selfExclusionOptions) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void changePassword(String oldPss, String newPss) {
        fillText(oldPasswordField, oldPss);
        fillText(newPasswordField, newPss);
        fillText(confirmPassword, newPss);
        clickOnElement(changePssButton);
    }

    public void chooseStay() {
        clickOnElement(stayRealityCheck);
    }

//    public void openTimeOutDropDown() {
//        clickOnElement(timeOutLimitDropDown);
//    }

    public boolean isDatePickerVisible() {
        return datePickerInTransactionsHistory.isDisplayed();
    }

    public void uploadUtilityBill() {
        fillText(utilityBillUpload, "/home/norayr/code/tests-winners-bet/src/test/resources/API.odt");
        clickOnElement(utilityBillUpload);
    }

    public boolean isRealityCheckVisible() {
        return realityCheckPopUp.isDisplayed();
    }


    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

    public void waitToWhiteLoaderIsNotDisplayed(){
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("whiteLoader")));
    }

    public void clickOnShowBalanceButton() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(showBalanceButtonElement);
    }

    public String getBalanceAmount() {
        return balance.getText();
    }

    public void clickOnSetLimitButtonBySectionName(String sectionName) {
        String xpath = "//h4[text() = 'SECTION_NAME']/ancestor::div[@class='ResponsibleGamingHeader']/ancestor::div/form/button[@class='mainButton']";
        scrollIntoElement(webDriver.findElement(By.xpath(xpath.replace("SECTION_NAME", sectionName))));
        clickOnElement(webDriver.findElement(By.xpath(xpath.replace("SECTION_NAME", sectionName))));
    }

    public String getSuccessMessage() {
        waitToWhiteLoaderIsNotDisplayed();
        return successMessage.getText();
    }

    public void inputDepositLimitAmount(String value) {
        fillText(depositLimitAmount, value);
    }
//
//    public void inputBetLimitAmount(String value) {
//        fillText(betLimitAmount, value);
//    }

    @Override
    protected void isLoaded() {
        waitToElementIsVisible(fullNameInAvatar);
        waitToElementClickable(myBets);
    }

}
