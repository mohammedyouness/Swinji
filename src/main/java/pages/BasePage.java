package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitElementToBeClickable(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement find(By locator) {
        waitElement(locator);
        highlightElement(locator);
        return driver.findElement(locator);
    }
    public void setText(By locator, String data) {
        waitElement(locator);
        find(locator).sendKeys(data);
    }
    public void click(By locator) {
        waitElement(locator);
        waitElementToBeClickable(locator);
        find(locator).click();
    }
    public void selectDataByText(By locator, String text) {
        Select select;
        select = new Select(find(locator));
        select.selectByVisibleText(text);
    }
    public String getContent(By locator) {
        waitElement(locator);
        return find(locator).getText();
    }
    public void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid fuchsia'", element);
    }
}
