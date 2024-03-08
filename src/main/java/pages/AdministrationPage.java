package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministrationPage extends BasePage {
    // Constructor
    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    public By tenantDisplayName = By.id("lblTenantDisplayName");
}
