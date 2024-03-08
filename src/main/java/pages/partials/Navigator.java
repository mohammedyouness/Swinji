package pages.partials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Navigator extends BasePage {
        // Constructor
        public Navigator(WebDriver driver) {
            super(driver);
        }
        // Elements Locators
        public By collapseAndExpandMenuIcon = By.id("btnMinifyMe");
        public By coursesOption = By.id("btnMyCoursesList");
        // Actions
        public void NavigateToCoursesPage() {
            click(collapseAndExpandMenuIcon);
            click(coursesOption);
        }

    }

