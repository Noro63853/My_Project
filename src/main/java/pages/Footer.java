package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Footer extends BasePage {


    @FindBy(xpath = "//div[@class='Footer']//li/a")
    List<WebElement> footerItems;

    @FindBy(className = "FAQContent")
    WebElement FAQ;

    @FindBy(className = "AboutUsContent")
    WebElement aboutUs;

    @FindBy(className = "PrivacyPolicyContent")
    WebElement privacyPolicy;

    @FindBy(className = "TermsAndConditionsContent")
    WebElement termsAndConditions;

    @FindBy(className = "CookiesPolicyContent")
    WebElement cookiesPolicy;

    @FindBy(className = "ResponsibleGamingContent")
    WebElement responsibleGaming;

    @FindBy(className = "BettingRulesContent")
    WebElement bettingRules;

    @FindBy(xpath = "//div[@class='socialIcons']/a")
    List<WebElement> socialIconElements;

    @FindBy(xpath = "//div[@class='payments']/div")
    List<WebElement> paymentsInFooterElement;

    @FindBy(xpath = "//div[@class='icon']/a")
    List<WebElement> partnersInFooterElements;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public void selectItemInFooter(String value) {
        waitToLoaderIsNotDisplayed();
        for (WebElement item : footerItems) {
            if (item.getText().equals(value)) {
                scrollIntoElement(item);
                clickOnElement(item);
                break;
            }
        }
    }

    public String getFAQText() {
        return FAQ.getText();
    }

    public String getAboutUsText() {
        return aboutUs.getText();
    }

    public String getPrivacyPolicyText() {
        return privacyPolicy.getText();
    }

    public String getTermsAndConditionsText() {
        return termsAndConditions.getText();
    }

    public String getCookiesPolicyText() {
        return cookiesPolicy.getText();
    }

    public String getResponsibleGamingText() {
        return responsibleGaming.getText();
    }

    public String getBettingRulesText() {
        return bettingRules.getText();
    }

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }


    public void selectSocialFooter(String socialName) {
        waitToLoaderIsNotDisplayed();
        for (WebElement socialIconElement : this.socialIconElements) {
            if (socialIconElement.getAttribute("aria-label").equals(socialName)) {
                scrollIntoElement(socialIconElement);
                clickOnElement(socialIconElement);
                break;
            }
        }

    }
//    public void goToSecondWindow() {
//
//        Set<String> windows = webDriver.getWindowHandles();
//        Iterator<String> itr = windows.iterator();
//        String childWindow = itr.next();
//        webDriver.switchTo().window(childWindow);
//
//    }

    public void selectPartnerInFooter(String partnerName) {
        for (WebElement partnersInFooterElement : this.partnersInFooterElements) {
            if (partnersInFooterElement.getAttribute("aria-label").equals(partnerName)) {
                scrollIntoElement(partnersInFooterElement);
                clickOnElement(partnersInFooterElement);
                break;
            }
        }
    }

    public void selectVisaPaymentInFooter() {
        scrollIntoElement(paymentsInFooterElement.get(0));
        clickOnElement(paymentsInFooterElement.get(0));
    }

}


