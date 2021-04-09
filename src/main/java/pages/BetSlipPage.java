package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class BetSlipPage extends BasePage {

    public final String OPENED_SETTINGS = "settingsButton settingsOpened";
//    public String DISABLED_BET_TYPE = "select-option disabled unselect";


//    public String CLOSED_BET_SLIP_CLASS = "betSlip";
    public final String OPENED_BET_SLIP_CLASS = "betSlip betSlipOpened";

    @FindBy(xpath = "//div[@class='bet-slip-buttons']//div")
    WebElement betSlipButton;

    @FindBy(xpath = "//div[@id='systemOptions']/div[@class='selectedOption']")
    WebElement systemOptionDropDown;

    @FindBy(css = ".BetlslipTypes .select-content")
    WebElement betTypeDropDown;

    @FindBy(className = "select-options")
    WebElement betTypes;

    @FindBy(className = "placeBetButton")
    WebElement placeBetButton;

    @FindBy(className = "selectedOdd")
    List<WebElement> selectedOddElements;

    @FindBy(className = "singleStake")
    List<WebElement> singleBetAmountFields;

    @FindBy(xpath = "//div[@class='dragAndDropSvg']")
    List<WebElement> dragIcons;

    @FindBy(className = "clearAllButton")
    WebElement clearButton;

    @FindBy(className = "settingsButton")
    WebElement settingsButton;

    @FindBy(xpath = "//div[@class='settingsOptions']//div[@class='selectedOption']")
    WebElement oddChangeType;

    @FindBy(className = "BetItem")
    List<WebElement> gameCardsInBetSlip;

    @FindBy(xpath = "//div[@class='stakeBlock']//input")
    WebElement betStakeField;

    @FindBy(xpath = "//div[@id='betslip']//span[@class='errorText']")
    WebElement errorTextInBetSlip;

    @FindBy(xpath = "//div[@class='placeBetContainer express']/div[text() = 'PLACE BET ']")
    WebElement inActivePlaceBet;

    @FindBy(xpath = "//div[text() = 'My Bets']")
    WebElement myBets;

    @FindBy(className = "noBets")
    WebElement noBets;

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }


    public BetSlipPage(WebDriver driver) {
        super(driver);
    }

    public void clearBetSlip() {
        clickOnElement(clearButton);
    }


    public String checkBetSlip() {
        return betSlipButton.getAttribute("class");
    }

    public String getOptionDropDown() {
        return systemOptionDropDown.getText();
    }

//    public void clickOnBetTypeButton(){
//        clickOnElement(betTypeDropDown);
//    }


    public void selectBetTypeTo(String betType) {
        List<WebElement> betTypesElements = betTypes.findElements(By.className("select-option"));
        for (WebElement element : betTypesElements) {
            if (element.getText().equals(betType)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void clickOnBetTypeDropDown() {
        webDriver.findElement(By.cssSelector(".BetlslipTypes .select-content")).click();
    }

    public String getErrorTextInBetSlip(){
        return errorTextInBetSlip.getText();
    }

    public void inputBetStake(String value){
        waitToElementIsVisible(betStakeField);
        betStakeField.clear();
        betStakeField.sendKeys(value);
    }

    public String getBetStakeField(){
        return betStakeField.getAttribute("value");
    }

    public List<WebElement> gameCardsInBetSlip(){
        return gameCardsInBetSlip;
    }

    public List<WebElement> countOfDragIcons() {
        return dragIcons;
    }

//    public ArrayList getOddsValues() {
//        ArrayList odds = new ArrayList();
//        for (WebElement selectedOddElement : selectedOddElements) {
//            String d = selectedOddElement.getText();
//            float intd = Float.parseFloat(d);
//            odds.add(intd);
//        }
//        return odds;
//    }

    public String getTextOfNoBets(){
        waitToLoaderIsNotDisplayed();
        return noBets.getText();
    }

    public String getPlaceBetButtonClass(){
        return inActivePlaceBet.getAttribute("class");
    }

    public String getPlaceBetButtonName(){
        waitToElementIsVisible(placeBetButton);
        return placeBetButton.getText();
    }

    public void placeBet(){
        clickOnElement(placeBetButton);
    }

    public void showSettings() {
        clickOnElement(settingsButton);
    }

    public String getSettingsText() {
        return settingsButton.getAttribute("class");
    }

//    public float multipleOdds() {
//        float d = 1;
//        for (int i = 0; i < getOddsValues().size(); i++) {
//            d *= (float) getOddsValues().get(i);
//
//        }
//        return d;
//    }

    public String getNameOfOddChangeType(){
        return oddChangeType.getText();
    }

//    public void openOddChangeType(){
//        clickOnElement(oddChangeType);
//    }

    public void openBetSlip() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(betSlipButton);
    }


    public List<WebElement> countOfSingleBetFields() {
        return singleBetAmountFields;
    }

    public String getBetType() {
        waitToElementIsVisible(betTypeDropDown);
        return betTypeDropDown.getText();
    }

    public void openBetTypeDropDown(){
        clickOnElement(betTypeDropDown);
    }

    public void openMyBets(){
        clickOnElement(myBets);
    }

//    public String getClassOfBetType(int value){
////        to do
//        return singleBetAmountFields.get(value).getAttribute("class");
//    }

    public boolean isBetTypeDisabled(String value){
        boolean isDisabled = false;
        List<WebElement> betTypesElements = betTypes.findElements(By.className("select-option"));
        for (WebElement element: betTypesElements){
            if (element.getText().equals(value) && element.getAttribute("class").contains("disabled")){
                isDisabled = true;
            }
        }
        return isDisabled;
    }
}
