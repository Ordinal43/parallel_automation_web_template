package utils.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Level;

import static utils.Constants.USE_GRID;
import static utils.Helpers.ENV;

public class WebDriverInstance {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            if (USE_GRID) {
                driver = RemoteWebDriver.builder()
                        .address(ENV("SELENIUM_GRID_URL"))
                        .addAlternative(chromeOptions())
                        .build();
            } else {
                WebDriverManager wdm = WebDriverManager.chromedriver();
                driver = wdm.create();
            }
        }
        return driver;
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        chromeOptions.setCapability("goog:loggingPrefs", logPrefs);

        return chromeOptions;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
