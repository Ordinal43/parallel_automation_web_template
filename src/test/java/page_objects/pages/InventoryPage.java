package page_objects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePage;

import static utils.drivers.WebDriverInstance.getDriver;

public class InventoryPage extends BasePage {
    @FindBy(xpath = "//*[@class='title' and text()='Products']")
    WebElement textTitleProduct;

    public InventoryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isOnPage() {
        return isDisplayed(textTitleProduct);
    }
}
