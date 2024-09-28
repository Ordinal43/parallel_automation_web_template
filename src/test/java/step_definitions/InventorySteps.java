package step_definitions;

import io.cucumber.java8.En;
import page_objects.pages.InventoryPage;

import static org.junit.Assert.assertTrue;

public class InventorySteps implements En {
    private final InventoryPage inventoryPage;

    public InventorySteps() {
        this.inventoryPage = new InventoryPage();

        Then("I am at the inventory page", () -> {
            assertTrue(inventoryPage.isOnPage());
        });
    }
}
