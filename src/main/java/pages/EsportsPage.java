package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;

import java.util.*;

public class EsportsPage extends BasePage {

//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.UK);


    public final String TITLE = "All Upcoming Esports Matches";

    public final String NO_GAMES_TEXT = "Sorry, there's no matches available right now";

//    public String[] homeAndLive = {"Home", "Live"};

//    public String OPEN_DROP_DOWN_CLASS = "select-content dropdown-open";
    public final String CLOSED_DROP_DOWN_CLASS = "select-content";

    public final ArrayList<String> esportItems = new ArrayList(Arrays.asList("Dota 2", "CS:GO", "StarCraft 2", "Rainbow Six", "Overwatch", "LoL", "Rocket League", "King of Glory", "Call Of Duty", "Fortnite", "Pubg", "Valorant", "Hearthstone", "Heroes of the Storm", "Smite", "World of Warcraft", "World of Tanks", "Halo", "FIFA", "Gears of War", "Clash Royale", "Street Fighter V", "Mortal Kombat XL", "Quake", "Street Fighter", "Tekken 7", "Warcraft III"));

//    @FindBy(css = ".GDPRCookiesPolicy>div>span")
//    WebElement coockiesPopup;

    @FindBy(xpath = "//span[@class='language']")
    WebElement language;

    @FindBy(xpath = "//div[@class='loadMore flex-all-center']")
    WebElement loadMoreMatches;

    @FindBy(xpath = "//span[@class='navItem']/a")
    List<WebElement> secNavInGeneral;

    @FindBy(xpath = "//div[@class='Select disableHighlight OddsType']/div[@class='select-wrapper']/div")
    WebElement oddTypeDropDown;

    @FindBy(xpath = "//div[@class='Select disableHighlight FilterBar marketFilter']/div[@class='select-wrapper']/div")
    WebElement marketFilter;

    @FindBy(xpath = "//div[@class='Select disableHighlight FilterBar']/div[@class='select-wrapper']/div")
    WebElement timeFilter;

    @FindBy(xpath = "//div[@class='tournamentsList']/a/span[1]")
    List<WebElement> tournamentsList;

    @FindBy(xpath = "//div[@class='Matches']/div[1]/div/span")
    WebElement firstEsportsMatch;

    @FindBy(className = "more-btn")
    WebElement seeMoreButtonEsports;

    @FindBy(xpath = "//main[@class='Main']//p")
    WebElement noGamesText;

    @FindBy(className = "wrapper")
    WebElement mainPage;

    @FindBy(xpath = "//main[@class='Main']//a")
    WebElement goLiveMatches;

    @FindBy(css = ".GDPRCookiesPolicy>div>a")
    WebElement acceptButtonInCookiesPopup;

    @FindBy(className = "nameBlock")
    List<WebElement> itemsInLeftMenu;

    @FindBy(className = "//div[@class='EsportListItem active']/span")
    WebElement gameCountForSelectedEsport;

//    @FindBy(className = "Events flex-all-center")
//    List<WebElement> matchesWithCoefficients;

    @FindBy(className = "gamesCount")
    List<WebElement> gamesCountElements;

    @FindBy(xpath = "//div[@class='NavigationMenu']/div/span")
    List<WebElement> homeAndLiveItems;

    @FindBy(xpath = "//div[@class='Matches']/div[1]/div[@class='Team left']")
    WebElement leftTeamNameInFirstEsportsMatch;

    @FindBy(xpath = "//div[@class='Matches']/div[1]/div[@class='Team right']")
    WebElement rightTeamNameInFirstEsportsMatch;

    @FindBy(xpath = "//div[@class='gameDetails']/div[@class='team'][1]/p")
    WebElement leftTeamNameInFirstEsportsGameBackground;

    @FindBy(xpath = "//div[@class='gameDetails']/div[@class='team'][2]/p")
    WebElement rightTeamNameInFirstEsportsGameBackground;

    @FindBy(xpath = "//div[@class='BackButton']/span")
    WebElement backButtonFromTournaments;

    @FindBy(className = "Main")
    WebElement mainPageOfEsports;

    @FindBy(css = ".Events .P1")
    List<WebElement> firstOddsOfMatches;

    @FindBy(xpath = "//div[@class='BackButton']//following-sibling::div/span")
    WebElement tournamentName;



    public EsportsPage(WebDriver driver) {
        super(driver);
    }

    public void closeCookiesPopup() {
        waitToLoaderIsNotDisplayed();
        if (acceptButtonInCookiesPopup != null) {
            clickOnElement(acceptButtonInCookiesPopup);
        }
    }

    public void showAllMatches() {
//        if (new WebDriverWait(webDriver,15).until(ExpectedConditions.presenceOfElementLocated)){
        scrollIntoElement(loadMoreMatches);
        clickOnElement(loadMoreMatches);
        showAllMatches();
    }
//    }

    public String getTournamentName() {
        return tournamentName.getText();
    }

    public void goBackFromTournamentPage() {
        clickOnElement(backButtonFromTournaments);
        waitToElementIsVisible(mainPage);
    }

    public void openEsport(String esport) {
//        openAllEsports();
        for (WebElement element : itemsInLeftMenu) {
            if (element.getText().equals(esport)) {
                clickOnElement(element);
                break;
            }
        }

    }

//    public void getEsportGameCount(String esport) {
//        openEsport(esport);
//        gameCountForSelectedEsport.getText();
//    }

    public String getTextFromEsportWithoutGame() {
        return noGamesText.getText();
    }

    public ArrayList getTeamsFromFirstEsportsGameBackground() {
        ArrayList arrayList = new ArrayList();
        clickOnElement(firstEsportsMatch);
        arrayList.add(leftTeamNameInFirstEsportsGameBackground.getText());
        arrayList.add(rightTeamNameInFirstEsportsGameBackground.getText());
        return arrayList;
    }


    public void clickOnEmptySpace() {
        clickOnElement(language);
    }

    public String getOddTypeClass() {
        return oddTypeDropDown.getAttribute("class");
    }

    public String getMarketFilterClass() {
        return marketFilter.getAttribute("class");
    }

    public String getTimeFilterClass() {
        return timeFilter.getAttribute("class");
    }

    public void goToLiveMatches() {
        clickOnElement(goLiveMatches);
    }

    public void goEsportByGameCount(String value) {
        for (WebElement element : gamesCountElements) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

    public void addOddsToBetSlip(int i) {
        waitToLoaderIsNotDisplayed();
        for (int j = 0; j < i; j++) {
            if (!firstOddsOfMatches.get(j).getAttribute("class").contains("isBlocked")) {
                Log.warn("Counts" + firstOddsOfMatches.size());
                clickOnElement(firstOddsOfMatches.get(j));
            }else {
                i = i + 1;
            }

        }
    }


    public String getTournamentNameByIndex(int value) {
        return tournamentsList.get(value).getText();
    }

    public EsportsPage openOddTypes() {
        clickOnElement(oddTypeDropDown);
        return this;
    }


    public EsportsPage openMarketFilter() {
        clickOnElement(marketFilter);
        return this;
    }

    public void openTimeFilter() {
        clickOnElement(timeFilter);
    }

    public void goToTheTournamentPage(int value) {
        clickOnElement(tournamentsList.get(value));
        waitToLoaderIsNotDisplayed();
    }



    public void goToTabFromSecNav(String value) {
        waitToLoaderIsNotDisplayed();
        for (WebElement tab : secNavInGeneral) {
            if (tab.getText().equals(value)) {
                clickOnElement(tab);
                waitToLoaderIsNotDisplayed();
                break;
            }
        }
        waitToElementIsVisible(mainPage);
    }

    public ArrayList getTeamsFromFirstEsportsGameCard() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(leftTeamNameInFirstEsportsMatch.getText());
        arrayList.add(rightTeamNameInFirstEsportsMatch.getText());
        return arrayList;
    }

//    public ArrayList getHomeAndLiveItems() {
//        ArrayList items = new ArrayList();
//        for (WebElement element : homeAndLiveItems) {
//            if (element.getAttribute("class").equals("")) {
//                items.add(element.getText());
//            }
//
//        }
//        return items;
//    }

    public void clickOnLoadMoreButton() {
        scrollIntoElement(seeMoreButtonEsports);
        clickOnElement(seeMoreButtonEsports);
    }

//    public ArrayList getEsportItems() {
//        clickOnLoadMoreButton();
//        ArrayList items = new ArrayList();
//        for (WebElement element : itemsInLeftMenu) {
//            items.add(element.getText());
//        }
//        Collections.sort(items, String.CASE_INSENSITIVE_ORDER);
//        return items;
//    }

//    public ArrayList getEsportItemsData() {
//        Collections.sort(esportItems, String.CASE_INSENSITIVE_ORDER);
//        return esportItems;
//    }

    public void selectEsportFromLeftMenu(String value) {
        for (WebElement element : itemsInLeftMenu) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
        waitToElementIsVisible(mainPageOfEsports);
    }

    @Override
    protected void isLoaded() throws Error {
        checkPageTitle(TITLE);
    }


}
