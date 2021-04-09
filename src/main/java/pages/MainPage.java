package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

//    public void clickOnButton(WebElement webElement) {
//        waitToElement(webElement);
//        waitToElementClickable(webElement);
//        scrollIntoElement(webElement);
//        waitToLoaderIsNotDisplayed();
//        webElement.click();
//    }

    public void waitToElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

    public void switchToNewWindow() {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
    }

    public void waitToTitleContains(String title) {
        this.webDriverWait.until(ExpectedConditions.titleContains(title));
    }
}
