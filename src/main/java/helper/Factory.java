package helper;

import config.AppConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Log;
import java.net.URL;
import java.util.Map;

public class Factory {

    public static WebDriver createWebDriver() {
        try {
            final WebDriver driver;
            AppConfig appConfig = ConfigFactory.create(AppConfig.class);
            Log.warn("ENVIRONMENT_NAME " + appConfig.getEnvironment());
            if (appConfig.getEnvironment().equals("local")) {
                Log.warn("Run on 'Local'");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", appConfig.getBrowserName());
                capabilities.setCapability("browserVersion", appConfig.getChromeBrowserVersion());
                capabilities.setCapability("selenoid:options", Map.of("enableVNC", true, "enableVideo", true));
                driver = new RemoteWebDriver(new URL(appConfig.getSelenoidHubUrl()), capabilities);
            }
            return driver;
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }
}