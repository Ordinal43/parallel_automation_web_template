package step_definitions;

import io.cucumber.java8.En;
import page_objects.pages.LoginPage;

import static org.junit.Assert.assertTrue;
import static utils.Constants.MAIN_URL;
import static utils.Helpers.TEST_DATA;
import static utils.drivers.WebDriverInstance.getDriver;

public class LoginSteps implements En {
    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();

        Given("I am at Swag Labs login page", () -> {
            getDriver().navigate().to(MAIN_URL);
            assertTrue(loginPage.isOnPage());
        });

        When("I log in using {string} account", (String user) -> {
            String username = TEST_DATA(String.format("%s_USERNAME", user));
            String password = TEST_DATA(String.format("%s_PASSWORD", user));
            loginPage.typeUsername(username);
            loginPage.typePassword(password);
            loginPage.clickSubmitLogin();
        });

        When("I log in with empty email", () -> {
            loginPage.typePassword("random");
            loginPage.clickSubmitLogin();
        });
        When("I log in with empty password", () -> {
            loginPage.typeUsername("random");
            loginPage.clickSubmitLogin();
        });
        Then("I get error login {string}", (String errorMessage) -> {
            assertTrue(loginPage.getMessageErrorLogin().contains(errorMessage));
        });
    }
}
