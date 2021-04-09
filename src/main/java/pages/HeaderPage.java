package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderPage extends BasePage {

//    @FindBy(xpath = "//span[@class='logo tt-landingHomeBtn']/img")
//    WebElement homeButtonInLandingPage;
//
//    @FindBy(xpath = "//img[@class='desktopLogo']")
//    WebElement homeButton;

    @FindBy(css = ".NavItems>li")
    List<WebElement> leftHeaderItems;

//    @FindBy(className = ".rightNavItems")
//    WebElement rightHeaderItem;

//    @FindBy(xpath = "//div[@class='Select disableHighlight ProfileDropDown']")
//    WebElement profileDropDown;

    @FindBy(css = ".select-options>div")
    List<WebElement> oddTypeOptions;

    @FindBy(xpath = "//li[@class='navItem active']")
    WebElement activeItemInLeftHeader;

    @FindBy(className = "login")
    WebElement loginButtonElement;



    @FindBy(className = "register")
    WebElement signUpButtonElement;


    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void selectTabInLeftHeader(String value) {
        waitToLoaderIsNotDisplayed();
        for (WebElement tabElement : leftHeaderItems) {
            if (tabElement.getText().equals(value)) {
                scrollIntoElement(tabElement);
                clickOnElement(tabElement);
                waitToLoaderIsNotDisplayed();
                break;
            }
        }
    }

    public WebElement text() {
        return activeItemInLeftHeader;
    }

//    public void goHomeFromLandingPage() {
//        waitToLoaderIsNotDisplayed();
//        clickOnElement(homeButtonInLandingPage);
//    }



//    public void goToHomePage() {
//        clickOnElement(homeButton);
//        waitToElementIsVisible(webDriver.findElement(By.xpath("//li[@class='navItem active']//span[text()='esports']")));
//
//    }

    public void clickOnLogin() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(loginButtonElement);
        waitToElement(webDriver.findElement(By.className("PopUp-signIn")));
    }



    public void clickOnSignUpButton() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(signUpButtonElement);
        waitToElement(webDriver.findElement(By.id("step1")));
    }


    public void waitToElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

//    public void selectOddType(String value) {
//        for (WebElement element : oddTypeOptions) {
//            if (element.getText().equals(value)) {
//                clickOnElement(element);
//                break;
//            }
//        }
//    }


}
