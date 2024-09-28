package page_objects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePage;

import static utils.drivers.WebDriverInstance.getDriver;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement inputUsername;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "login-button")
    private WebElement btnSubmitLogin;
    @FindBy(css = "h3[data-test='error']")
    private WebElement textErrorLogin;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isOnPage() {
        return isDisplayed(inputUsername);
    }

    public void typeUsername(String username) {
        type(inputUsername, username);
    }

    public void typePassword(String password) {
        type(inputPassword, password);
    }

    public void clickSubmitLogin() {
        click(btnSubmitLogin);
    }

    public String getMessageErrorLogin() {
        return getText(textErrorLogin);
    }
}
