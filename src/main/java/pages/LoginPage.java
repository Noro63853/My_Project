package pages;

import helper.UserObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends MainPage {

    public final String ERROR_TEXT = "Wrong username or password. Please, enter valid credentials.";
//    public String ERROR_TEXT_NOT_CONFIRMED = "Please, verify your email.";
//    public String VALID_EMAIL_FOR_FORGOT = "norayr33@mailinator.com";
    public final String INVALID_EMAIL_FOR_FORGOT = "fngo@mailinator.com";
    public final String SUCCESS_MESSAGE_FOR_FORGOT = "Please check your email for recovery link.";
    public final String THE_FIRST_NAME_OF_SEND_BUTTON_IN_FORGOT = "GET RECOVERY LINK";
    public final String THE_Second_NAME_OF_SEND_BUTTON_IN_FORGOT = "RESEND";
    public final String NOT_REGISTERED_EMAIL_MESSAGE_FOR_FORGOT = "The email is not registered.";

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameInLogin;


    @FindBy(name = "password")
    WebElement passwordInLogin;

    @FindBy(className = "SignIn")
    WebElement signInPopUp;

//    @FindBy(className = "tt-closePopup")
//    WebElement xLoginPopUp;

    @FindBy(className = "mainButton")
    WebElement loginButton;

    @FindBy(className = "mainButton")
    WebElement loginButtonInPopupElement;

//    @FindBy(xpath = "//div[contains(@class, 'error') and text() = 'Password field cannot be empty.']")
//    WebElement errorTextForEmptyPasswordField;

//    @FindBy(xpath = "//div[contains(@class, 'error') and text() = 'Username field cannot be empty.']")
//    WebElement errorTextForEmptyUsernameField;

    @FindBy(xpath = "//div[@class='forgotPassword']/div[@class='success']")
    WebElement successMessageOfForgotPassword;

    @FindBy(xpath = "//div[@class='forgotPassword']//button[@class='recoverLinkButton']")
    WebElement sendButtonInForgot;

    @FindBy(xpath = "//div[@class='forgotPassword']//div[@class='error']")
    WebElement invalidEmailForForgot;

    @FindBy(className = "forgotPasswordButton")
    WebElement forgotButtonElement;

    @FindBy(className = "recoverLinkButton")
    WebElement recoveryLinkButtonElement;

    @FindBy(className = "inputWrapper")
    WebElement emailForgotElement;

//    @FindBy(className = "registernowButton")
//    WebElement registerInLogin;

//    @FindBy(className = "register")
//    WebElement signUpButtonElement;

    @FindBy(className = "error")
    WebElement invalidLoginError;

    @FindBy(className = "Select disableHighlight ProfileDropDown")
    WebElement profileDropDown;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(UserObject userObject) {
        waitToElementIsVisible(signInPopUp);
        waitToElementIsVisible(loginButton);
        fillText(userNameInLogin, userObject.getUserName());
        fillText(passwordInLogin, userObject.getPassword());
    }

    public void clickOnLoginButtonInPopUp() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(loginButtonInPopupElement);
        waitToSignInPopUpIsNotDisplayed();
    }

    public void clickOnLoginButtonAndPopupNotClosed() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(loginButtonInPopupElement);
    }
    public boolean isLoginPopUpVisible() {
        return signInPopUp.isDisplayed();
    }

    public String getErrorMessage() {
        return invalidLoginError.getText();
    }

    public String getSendButtonNameInForgot() {
        return sendButtonInForgot.getText();
    }

    public boolean isSendButtonInForgotActive() {
        return sendButtonInForgot.isEnabled();
    }

    public void clickOnForgotPassword() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(forgotButtonElement);
        waitToElement(webDriver.findElement(By.className("forgotPassword")));
    }

    public void clickOnRecoveryLinkButton() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(recoveryLinkButtonElement);
    }

    public void fillValueInForgotEmailField(String value) {
        waitToLoaderIsNotDisplayed();
        fillText(emailForgotElement.findElement(By.tagName("input")), value);
    }

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

    public void waitToSignInPopUpIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("SignIn")));
    }

//    public void waitToPopUpIsNotDisplayed() {
//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("PopUp PopUp-signIn")));
//    }

    public void fillValueOnEmailField(String value) {
        waitToElementIsVisible(emailForgotElement);
        fillText(emailForgotElement.findElement(By.tagName("input")), value);
    }

    public String getSuccessMessageOfForgotPassword() {
        return successMessageOfForgotPassword.getText();
    }

//    public void closeLoginPopUp() {
//        clickOnElement(xLoginPopUp);
//    }

    public String getErrorMessageOfForgotPassword() {
        clickOnElement(sendButtonInForgot);
        return invalidEmailForForgot.getText();
    }

    public Boolean isLoginButtonDisabled() {
        return loginButton.isEnabled();
    }

    @Override
    public void isLoaded() {
        waitToElementIsVisible(profileDropDown);
    }
}
