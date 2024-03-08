package gui.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AdministrationPage;
import pages.BasePage;
import pages.CoursesPage;
import pages.LoginPage;
import pages.partials.Navigator;

public class BaseTest {
    protected WebDriver driver;
    BasePage basePage;
    LoginPage loginPage;
    AdministrationPage administrationPage;
    CoursesPage coursesPage;
    Navigator navigator;

    /**
     * 1.	What are the different types of locators in Selenium?
     * ID: Locating elements by their unique ID attribute.
     * Name: Locating elements by their name attribute.
     * Class Name: Locating elements by their class attribute.
     * Tag Name: Locating elements by their HTML tag name
     * XPath: XPath (XML Path Language) is a powerful locator strategy that uses expressions to navigate through elements in an XML document. It can traverse the entire document and is capable of selecting complex elements based on their attributes and relationships.
     * CSS Selector: CSS (Cascading Style Sheets) selectors allow you to target elements based on their CSS attributes, such as class, ID, or attributes.
     * Link Text: Locating anchor elements (<a> tags) by the visible text within the anchor tag.
     * Partial Link Text: Locating anchor elements by a partial match of their visible text.
     *
     * 2.	What are the different types of Drivers available in WebDriver?
     * FirefoxDriver: This driver is used to automate the Mozilla Firefox browser.
     * ChromeDriver: ChromeDriver is used to automate the Google Chrome browser.
     * InternetExplorerDriver: InternetExplorerDriver is used to automate the Internet Explorer browse
     * EdgeDriver: EdgeDriver is used to automate the Microsoft Edge browser.
     * SafariDriver: SafariDriver is used to automate the Safari browser on macOS.
     * OperaDriver: OperaDriver is used to automate the Opera browser.
     * HtmlUnitDriver: HtmlUnitDriver is a headless browser implementation that simulates the behavior of a browser
     * without rendering the UI. It is useful for fast and lightweight testing.
     * RemoteWebDriver: RemoteWebDriver allows you to execute tests on remote machines or Selenium Grid, enabling
     * cross-browser testing on different platforms and environments.
     *
     * 3.	What are the different types of waits available in WebDriver?
     *In Selenium WebDriver, there are three main types of waits available:
     *
     * Implicit Waits:
     * Implicit waits instruct WebDriver to wait for a certain amount of time before throwing an exception if an element is not immediately present.
     * It is applied globally, meaning it affects all subsequent WebDriver commands.
     * It's useful for scenarios where elements may take varying amounts of time to load.
     * Implicit waits can be set using the implicitlyWait() method.
     *
     * Explicit Waits:
     * Explicit waits tell WebDriver to wait for a certain condition to occur before proceeding with the execution.
     * It allows waiting for specific conditions on certain elements with more precision than implicit waits.
     * Explicit waits are applied to specific elements or conditions using the WebDriverWait class.
     * WebDriverWait is used in conjunction with ExpectedConditions to define the conditions to wait for,
     * such as element visibility, element presence, element click ability, etc.
     *
     * Fluent Wait:
     * FluentWait is an extension of WebDriverWait that provides more flexible and customized wait conditions.
     * It allows defining the polling interval, maximum wait time, and exceptions to ignore during the wait.
     * FluentWait is useful when dealing with dynamic web elements or situations where explicit waits alone may not be
     * sufficient.
     * It is more powerful but also more complex compared to implicit and explicit waits.
     * Each type of wait has its use cases and advantages, and the choice depends on the specific requirements of the
     * test scenario.
     *
     * 4.	What is the difference between driver.quite() and driver.close()?
     * driver.quit() is used to close all browser windows and terminate the WebDriver session completely
     * driver.close() is used to close the current browser window or tab that the WebDriver is currently controlling
     */


    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*")
                .addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String url = "https://swinji.azurewebsites.net/account/login";
        driver.navigate().to(url);
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        administrationPage = new AdministrationPage(driver);
        coursesPage = new CoursesPage(driver);
        navigator = new Navigator(driver);
    }

    @After
    public void tearDown() {
        // driver.quit();
    }
}
