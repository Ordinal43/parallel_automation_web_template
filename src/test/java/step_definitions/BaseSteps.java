package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;
import static utils.drivers.WebDriverInstance.getDriver;

public class BaseSteps {
    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        getDriver().navigate().to(url);
    }

    @Then("I verify the page title contains {string}")
    public void iVerifyThePageTitleContains(String expectedPageTitle) {
        String actualPageTitle = getDriver().getTitle();
        assertTrue(actualPageTitle.contains(expectedPageTitle));
    }
}
