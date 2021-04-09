package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helper.ConfigFileReader;

public class WelcomePage extends BasePage {
    public final String TITLE = "Welcome to Winners.bet";
    public final ConfigFileReader reader = ConfigFileReader.getConfigFileReader();


//    @FindBy(className = "LandingPage")
//    WebElement landingPage;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

//    @Override
//    protected void load() {
//        webDriver.get(reader.getBaseUrl());
//        waitToElementIsVisible(landingPage);
//    }
//
//    @Override
//    protected void isLoaded() {
//        checkPageTitle(TITLE);
//    }
}
