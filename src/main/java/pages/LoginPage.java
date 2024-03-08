package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Elements Locators
    public By emailField = By.id("Email");
    public By passwordField = By.id("inputPassword");
    public By loginBtn = By.id("btnLogin");

    // Actions
    public void login(String username, String password) {
        setText(emailField, username);
        setText(passwordField, password);
        click(loginBtn);
    }

}
