package step_definitions;

import io.cucumber.java8.En;

import static org.junit.Assert.assertTrue;
import static utils.Constants.MAIN_URL;
import static utils.drivers.WebDriverInstance.getDriver;

public class BaseSteps implements En {
    public BaseSteps() {
        When("I navigate to Swag Labs website", () -> {
            getDriver().navigate().to(MAIN_URL);
        });

        Then("I verify the page title contains {string}", (String expectedPageTitle) -> {
            String actualPageTitle = getDriver().getTitle();
            assertTrue(actualPageTitle.contains(expectedPageTitle));
        });
    }
}
