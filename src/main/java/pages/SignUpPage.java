package pages;

import helper.UserObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage {

    public final String SUCCESS_MESSAGE = "You have successfully signed up." + System.lineSeparator() + " Please check your email and verify your account";
    public final String EMAIL_ERROR_MESSAGE = "Invalid email address.";

    @FindBy(xpath = "//form//input")
    List<WebElement> fieldsInStep1;

    @FindBy(xpath = "//button[@class='mainButton']")
    WebElement continueToStep2Button;

    @FindBy(className = "react-datepicker__input-container")
    WebElement dateOfBirth;

    @FindBy(xpath = "//div[@class='react-datepicker__month']/div[1]/div[1]")
    WebElement firstDayOfTheMonth;

    @FindBy(xpath = "//div[@class='Select disableHighlight gender']/div")
    WebElement genderPopUp;

    @FindBy(xpath = "//div[contains(@class, 'select-option') and text() = 'Male']")
    WebElement maleOption;

    @FindBy(xpath = "//div[@class='Select disableHighlight country_code']/div[@class='select-wrapper']")
    WebElement countryPopUp;

    @FindBy(xpath = "//div[contains(@class, 'select-option') and text() = 'Armenia']")
    WebElement armeniaInCountryPopUp;

    @FindBy(className = "form-control")
    WebElement phoneNumber;

    @FindBy(xpath = "//form[@id='step2']//input")
    List<WebElement> fieldsInStep2;

    @FindBy(xpath = "//button[@class='mainButton']")
    WebElement continueToStep3Button;

//    @FindBy(xpath = "//div[@class='Select disableHighlight currency_name']//div[@class='select-wrapper']")
//    WebElement currencyDropDown;

//    @FindBy(xpath = "//div[contains(@class, 'select-option') and text() = 'CAD']")
//    WebElement cadOptionInCurrencyDropDown;

    @FindBy(xpath = "//label[contains(@class, 'custom-control-label') and text() = 'By joining you agree to our']")
    WebElement termsCheckBox;

    @FindBy(xpath = "//button[@class='mainButton']")
    WebElement finishRegistrationButton;

    @FindBy(xpath = "//div[@class='checkEmail']//div[@class='footer']//p")
    WebElement successRegisterMessage;

    @FindBy(xpath = "//div[contains(@class, 'error') and text() = 'Invalid email address.']")
    WebElement emailError;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void inputFieldInStep1(String value, String value2) {
        for (WebElement tabElement : fieldsInStep1) {
            if (tabElement.getAttribute("name").equals(value)) {
                fillText(tabElement, value2);
                break;
            }
        }
    }

    public String invalidEmailError(){
        return emailError.getText();
    }

    public SignUpPage chooseTheFirstDayOfTheMonthAsDob() {
        clickOnElement(dateOfBirth);
        clickOnElement(firstDayOfTheMonth);
        return this;

    }

    public SignUpPage chooseMaleAsGender() {
        clickOnElement(genderPopUp);
        clickOnElement(maleOption);
        return this;
    }

    public void chooseArmeniaAsCountry() {
        clickOnElement(countryPopUp);
        clickOnElement(armeniaInCountryPopUp);
    }

    public SignUpPage selectPhoneNumber(String phoneNumber) {
        fillText(this.phoneNumber, phoneNumber);
        return this;
    }

    public void inputFieldInStep2(String value, String value2) {
        for (WebElement tabElement : fieldsInStep2) {
            if (tabElement.getAttribute("name").equals(value)) {
                fillText(tabElement, value2);
                break;
            }
        }
    }

//    public SignUpPage chooseCadAsCurrency() {
//        clickOnElement(currencyDropDown);
//        clickOnElement(cadOptionInCurrencyDropDown);
//        return this;
//    }

    public SignUpPage checkTermsCheckBox() {
        clickOnElement(termsCheckBox);
        return this;
    }

    public void finishRegistration() {
        clickOnElement(finishRegistrationButton);
    }


    public SignUpPage passStep1(UserObject userObject) {
        inputFieldInStep1("email", userObject.getEmail());
        inputFieldInStep1("username", userObject.getUserName());
        inputFieldInStep1("first_name", userObject.getFirstName());
        inputFieldInStep1("last_name", userObject.getLastName());
        inputFieldInStep1("password", userObject.getPassword());
        clickOnElement(continueToStep2Button);
        return this;
    }

    public void fillAllFieldsInStep1(UserObject userObject){
        inputFieldInStep1("email", userObject.getEmail());
        inputFieldInStep1("username", userObject.getUserName());
        inputFieldInStep1("first_name", userObject.getFirstName());
        inputFieldInStep1("last_name", userObject.getLastName());
        inputFieldInStep1("password", userObject.getPassword());
    }

    public SignUpPage passStep2(UserObject userObject) {
        chooseTheFirstDayOfTheMonthAsDob()
                .chooseMaleAsGender()
                .chooseArmeniaAsCountry();
        inputFieldInStep2("city", userObject.getCity());
        inputFieldInStep2("address1", userObject.getAddress1());
        inputFieldInStep2("address2", userObject.getAddress2());
        inputFieldInStep2("province", userObject.getProvince());
        inputFieldInStep2("zip_code", userObject.getZipCode());
        selectPhoneNumber(userObject.getPhoneNumber())
                .clickOnElement(continueToStep3Button);
        return this;
    }

    public void register(UserObject userObject) {
        passStep1(userObject)
                .passStep2(userObject)
                .checkTermsCheckBox()
                .finishRegistration();
    }

    public String getSuccessRegisterMessage() {
        return successRegisterMessage.getText();
    }


}
