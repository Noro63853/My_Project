package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasinoPage extends BasePage{

    public final String TITLE = "Winners.bet - Esports Betting";

    public final ArrayList casinoProvidersProd = new ArrayList(Arrays.asList("All games (A-Z)", "Netent", "Hacksaw", "Nolimit City", "Pragmatic Play", "Skywind", "TOM HORN", "Spadegaming", "1X2 Network", "PLAYSON", "Relax Gaming", "RED RAKE", "Booming Games"));
    public final ArrayList casinoProvidersStaging = new ArrayList(Arrays.asList("All games (A-Z)", "Pragmatic Play", "1x2 Network"));

    @FindBy(xpath = "//span[contains(@class, 'providerName') and text() = 'All games (A-Z)'] ")
    WebElement allGamesInCasino;

//    @FindBy(className = "CasinoLeftMenu")
//    WebElement casinoLeftMenu;

    @FindBy(css = ".nameBlock")
    List<WebElement> providersList;

    @FindBy(xpath = "//div[@class='providersList']//div[@class='nameBlock']")
    List<WebElement> providersInCasino;


    public CasinoPage(WebDriver driver) {
        super(driver);
    }

//    public boolean isCasinoPageAvailable(){
//        if (allGamesInCasino != null){
//            return true;
//        }else {
//            System.out.println("All Games section is not available");
//            return false;
//        }
//    }

    @FindBy(xpath = "//span[contains(@class, 'providerName') and text() = '1x2 Network']")
    WebElement pragmatic;

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

    public void goBackFromCasinoPage(){
        webDriver.navigate().back();
        waitToLoaderIsNotDisplayed();
    }

    public void clickOnProvider(String value){
        for (WebElement provider: providersList){
            if (provider.getText().equals(value)){
                provider.click();
                break;
            }
        }
//        waitToLoaderIsNotDisplayed();
    }

    public void clickOnPragmatic(){
        clickOnElement(pragmatic);
    }



    public ArrayList getProvidersInCasino(){
        ArrayList items = new ArrayList();
        for (WebElement element : providersInCasino) {
            items.add(element.getText());
        }
        return items;
    }

}
