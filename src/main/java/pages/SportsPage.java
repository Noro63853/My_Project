package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SportsPage extends BasePage {

//    ConfigFileReader reader = ConfigFileReader.getConfigFileReader();
    final Random random = new Random();

    public final String TITLE = "Bet live on null at Winners.bet .";

    public final ArrayList<String> sportItems = new ArrayList<>(Arrays.asList("Live", "Football", "Basketball", "Tennis", "Volleyball", "Table Tennis", "Baseball", "Ice Hockey", "Handball", "American Football", "Badminton", "Cricket", "Beach Volleyball", "MMA", "Futsal", "Snooker", "Rugby Union", "Rugby League", "Darts", "Boxing", "Aussie Rules", "Golf", "Formula 1", "Squash", "Cycling", "Biathlon", "Speedway", "Special bets", "Cross-Country Skiing", "Air Hockey", "TV Shows and Movies", "Politics", "NASCAR", "WWE", "Sailing"));
    public final ArrayList<String> FOOTBALL_MARKETS = new ArrayList<>(Arrays.asList("Match Result", "Total Goals", "Both Teams To Score", "1st Half Result", "Double Chance"));
    public final ArrayList<String> BASKETBALL_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Match Result (Regular Time)", "Total Points", "Points Handicap"));
    public final ArrayList<String> ICE_HOCKEY_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Match Result (regular time)", "Total Goals", "Goals Handicap"));
    public final ArrayList<String> HANDBALL_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Match Result", "Total Goals"));
    public final ArrayList<String> RUGBY_UNION_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Match Result", "Total Points", "Points Handicap"));
    public final ArrayList<String> Darts_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Match Result", "Total Legs", "Legs Handicap"));
    public final ArrayList<String> TENNIS_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Total Games", "Game Handicap", "Sets Handicap", "Set Betting"));
    public final ArrayList<String> VOLLEYBALL_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Total Points", "Total Sets", "Points Handicap", "Sets Handicap"));
    public final ArrayList<String> TABLE_TENNIS_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Total Sets", "Player 1 Total Points", "Player 2 Total Points"));
    public final ArrayList<String> BASEBALL_MARKETS = new ArrayList<>(Arrays.asList("Money Line", "Total Runs", "Run Line", "Team 1 Total Runs", "Team 2 Total Runs"));
    public final ArrayList<String> AMERICAN_FOOTBALL_MARKETS = new ArrayList<>(Arrays.asList("Money Line", "Total Points", "Points Handicap"));
    public final ArrayList<String> AUSSIE_RULES_MARKETS = new ArrayList<>(Arrays.asList("Match Winner", "Total Points", "Points Handicap"));
    public final ArrayList<String> DATES_IN_FILTER = new ArrayList<>(Arrays.asList("All Time", "1 Hour", "2 Hours", "6 Hours", "12 Hours", "Day", "Week"));

    @FindBy(xpath = "//div[@class='SportsNavigation']/a/span[@class='game-name']")
    List<WebElement> sportsInLeftMenu;

    @FindBy(className = "more-btn")
    WebElement seeMoreButtonSports;

    @FindBy(className = "Main")
    WebElement mainPage;

    @FindBy(className = "SportsLeftMenu")
    WebElement leftMenu;


    @FindBy(xpath = "//div[@class='Select disableHighlight FilterBar marketFilter']//div[@class='select-content']")
    WebElement marketFilter;

    @FindBy(xpath = "//div[@class='Select disableHighlight FilterBar marketFilter']//div[@class='select-options']/div")
    List<WebElement> marketsInFilter;

    @FindBy(xpath = "//div[@class='Select disableHighlight FilterBar']")
    WebElement dateFilter;

    @FindBy(xpath = "//div[@class='Select disableHighlight FilterBar']//div[@class='select-options']/div")
    List<WebElement> datesInFilter;

    @FindBy(className = "sport-competitions-content")
    WebElement matches;

    @FindBy(xpath = "//div[@class='sport-game-events']/div[1]/span[1][@class='event-status']")
    List<WebElement> firstMatches;
    @FindBy(xpath = "//div[@class='sport-game-events']/div[2]/span[1][@class='event-status']")
    List<WebElement> secondMatches;
    @FindBy(xpath = "//div[@class='sport-game-events']/div[3]/span[1][@class='event-status']")
    List<WebElement> thirdMatches;
    @FindBy(xpath = "//div[@class='sport-game-events']/div[4]/span[1][@class='event-status']")
    List<WebElement> fourthMatches;

    @FindBy(className = "loadMore flex-all-center")
    WebElement loadMoreMatches;


    public SportsPage(WebDriver driver) {
        super(driver);
    }

    public String getTheNameOfFirstOddOfRandomMatch() {
        if (firstMatches.size() > 0) {
            int first = random.nextInt(firstMatches.size());
            return firstMatches.get(first).getText();
        } else return "";
    }

    public String getTheNameOfSecondOddOfRandomMatch() {
        if (secondMatches.size() > 0) {
            int second = random.nextInt(secondMatches.size());
            return secondMatches.get(second).getText();
        } else return "";
    }

    public String getTheNameOfThirdOddOfRandomMatch() {
        int third = random.nextInt(thirdMatches.size());
        return thirdMatches.get(third).getText();
    }

    public String getTheNameOfFourthOddOfRandomMatch() {
        int fourth = random.nextInt(fourthMatches.size());
        return fourthMatches.get(fourth).getText();
    }

    public void openAllSports() {
        waitToLoaderIsNotDisplayed();
        if (seeMoreButtonSports.isDisplayed()) {
            clickOnElement(seeMoreButtonSports);
        }
    }

//    public void loadMoreMatches() {
//        if (loadMoreMatches.isDisplayed()) {
//            clickOnElement(loadMoreMatches);
//        }
//    }

    public ArrayList<String> getSportItems() {
        ArrayList<String> items = new ArrayList<>();
        waitToLoaderIsNotDisplayed();
        for (WebElement element : sportsInLeftMenu) {
            items.add(element.getText());
        }
        return items;
    }

    public void openMarketFilter() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(marketFilter);
    }

    public void clickOnDateFilter() {
        waitToLoaderIsNotDisplayed();
        clickOnElement(dateFilter);
    }

    public ArrayList<String> getMarkets() {
        ArrayList<String> markets = new ArrayList<String>();
        waitToLoaderIsNotDisplayed();
        for (WebElement element : marketsInFilter) {
            markets.add(element.getText());
        }
        return markets;
    }

    public ArrayList<String> getDatesFromDateFilter() {
        ArrayList<String> dates = new ArrayList<>();
        waitToLoaderIsNotDisplayed();
        for (WebElement element : datesInFilter) {
            dates.add(element.getText());
        }
        return dates;
    }

    public String getSelectedMarket() {
        return marketFilter.getText();
    }

    public void chooseMarketInFilter(String marketName) {
        waitToLoaderIsNotDisplayed();
        for (WebElement element : marketsInFilter) {
            if (element.getText().equals(marketName)) {
                Actions action = new Actions(webDriver);
                action.moveToElement(element).click().perform();
                break;
            }
        }
    }

    public void openSportFromLeftMenu(String value) {
        waitToLoaderIsNotDisplayed();
        openAllSports();
        for (WebElement element : sportsInLeftMenu) {
            if (element.getText().equals(value)) {
//                scrollIntoElement(element);
                clickOnElement(element);
                break;
            }
        }
        waitToElementIsVisible(matches);
    }

    public void waitToLoaderIsNotDisplayed() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
    }

    @Override
    protected void isLoaded() throws Error {
        checkPageTitle(TITLE);
        waitToElementIsVisible(mainPage);
        waitToElementIsVisible(leftMenu);
    }
}
