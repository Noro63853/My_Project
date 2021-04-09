package tests;

import helper.UserObject;
import com.fasterxml.jackson.databind.JsonNode;
import config.AppConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.*;
import helper.DataFileReader;
import helper.Factory;
import utils.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public AppConfig appConfig;
    public String baseUrl;
    protected final String USER_CREDENTIALS_FILE_PATH = "src/test/resources/client_data.json";
    protected final String FOOTER_TEXTS = "src/test/resources/footer.json";
    private ThreadLocal<WebDriver> driver;
    protected EsportsPage esportsPage;
    protected SportsPage sportsPage;
    protected HeaderPage headerPage;
    protected CasinoPage casinoPage;
    protected PromotionsPage promotionsPage;
    protected ProfilePage profilePage;
    protected UserObject loginUserForStaging, loginUserForProd, signUpUser, nokSignUpUser, nokLoginUser, notConfirmedLoginUserForStaging, notConfirmedLoginUserForProd;
    protected DataFileReader dataFileReader;
    protected JsonNode jsonNode1, jsonNode2;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected BetSlipPage betSlipPage;
//    protected WelcomePage welcomePage;
    protected MainPage mainPage;
    protected SoftAssert softAssert;
    protected Footer footer;


    protected WebDriver webDriver() {
        return driver.get();
    }

    @BeforeClass(alwaysRun = true, description = "Before method")
    public void setup() throws ElementNotInteractableException {
        appConfig = ConfigFactory.create(AppConfig.class);
        baseUrl = appConfig.getBaseUrl();
        Log.warn("BASE_URL" + appConfig.getBaseUrl());
        driver = new ThreadLocal<>();
        driver.set(Factory.createWebDriver());
        // Pages initialization
        dataFileReader = new DataFileReader();
        softAssert = new SoftAssert();
        jsonNode1 = dataFileReader.getPOJOFile(USER_CREDENTIALS_FILE_PATH);
        jsonNode2 = dataFileReader.getPOJOFile(FOOTER_TEXTS);
        esportsPage = PageFactory.initElements(webDriver(), EsportsPage.class);
        headerPage = PageFactory.initElements(webDriver(), HeaderPage.class);
        sportsPage = PageFactory.initElements(webDriver(), SportsPage.class);
        casinoPage = PageFactory.initElements(webDriver(), CasinoPage.class);
        promotionsPage = PageFactory.initElements(webDriver(), PromotionsPage.class);
        footer = PageFactory.initElements(webDriver(), Footer.class);
        profilePage = PageFactory.initElements(webDriver(), ProfilePage.class);
        loginPage = PageFactory.initElements(webDriver(), LoginPage.class);
        signUpPage = PageFactory.initElements(webDriver(), SignUpPage.class);
        betSlipPage = PageFactory.initElements(webDriver(), BetSlipPage.class);
//        welcomePage = PageFactory.initElements(webDriver(), WelcomePage.class);
        mainPage = PageFactory.initElements(webDriver(), MainPage.class);
        // Data initialization
        loginUserForStaging = new UserObject(jsonNode1.get("validUsernameForStaging").textValue(), jsonNode1.get("validPassword").textValue());
        loginUserForProd = new UserObject(jsonNode1.get("validUsernameForProd").textValue(), jsonNode1.get("validPassword").textValue());
        nokLoginUser = new UserObject(jsonNode1.get("invalidUsername").textValue(), jsonNode1.get("validPassword").textValue());
        notConfirmedLoginUserForStaging = new UserObject(jsonNode1.get("notConfirmedUsernameForStaging").textValue(), jsonNode1.get("notConfirmedPassword").textValue());
        notConfirmedLoginUserForProd = new UserObject(jsonNode1.get("notConfirmedUsernameForProd").textValue(), jsonNode1.get("notConfirmedPassword").textValue());
        signUpUser = new UserObject(jsonNode1.get("validSignUpEmail").textValue(), jsonNode1.get("validSignUpUsername").textValue(), jsonNode1.get("validSignUpFirstName").textValue(), jsonNode1.get("validSignUpLastName").textValue(), jsonNode1.get("validSignUpPassword").textValue(), jsonNode1.get("validSignUpCity").textValue(), jsonNode1.get("validSignUpAddress1").textValue(), jsonNode1.get("validSignUpAddress2").textValue(), jsonNode1.get("validSignUpProvince").textValue(), jsonNode1.get("validSignUpZipCode").textValue(), jsonNode1.get("validSignUpPhoneNumber").textValue());
        nokSignUpUser = new UserObject(jsonNode1.get("invalidSignUpEmail").textValue(), jsonNode1.get("validSignUpUsername").textValue(), jsonNode1.get("validSignUpFirstName").textValue(), jsonNode1.get("validSignUpLastName").textValue(), jsonNode1.get("validSignUpPassword").textValue(), jsonNode1.get("validSignUpCity").textValue(), jsonNode1.get("validSignUpAddress1").textValue(), jsonNode1.get("validSignUpAddress2").textValue(), jsonNode1.get("validSignUpProvince").textValue(), jsonNode1.get("validSignUpZipCode").textValue(), jsonNode1.get("validSignUpPhoneNumber").textValue());
        webDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver().manage().window().maximize();
        Log.warn("BASEURLLLLLLLLLLLLLL" + baseUrl);
        webDriver().navigate().to(baseUrl + "/esports/home/matches");
        esportsPage.closeCookiesPopup();



    }

    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) webDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots" + System.currentTimeMillis() + "failed.png"));
        }
    }

    @AfterClass(alwaysRun = true, description = "After method")
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
