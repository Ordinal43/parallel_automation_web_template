package utils.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static utils.drivers.WebDriverInstance.getDriver;
import static utils.drivers.WebDriverInstance.quitDriver;

public class Hooks {
    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public static void before(Scenario scenario) {
        getDriver();
    }

    @After
    public static void after(Scenario scenario) {
        if (getDriver() != null) {
            if (scenario.isFailed()) {
                scenario.log("Scenario failed so capturing a screenshot");

                final byte[] data = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(data, "image/png", "Failed Screenshot");
            }
            quitDriver();
        } else {
            scenario.log("Driver failed to start!");
        }
    }
}
