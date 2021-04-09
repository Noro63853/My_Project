package pages;

import org.openqa.selenium.WebDriver;

public class PromotionsPage extends BasePage{

    public final String TITLE = "Winners.bet offers the best Esports betting bonuses!";
    public PromotionsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() throws Error {
        checkPageTitle(TITLE);
    }
}
