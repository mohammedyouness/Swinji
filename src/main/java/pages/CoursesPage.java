package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class CoursesPage extends BasePage{

    // Constructor
    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    // Elements Locators
    public By addCourseBtn = By.cssSelector("button#btnListAddCourse");
    public By courseTitle = By.cssSelector("a#lnkListCourseSelcted");
    public By searchBar = By.cssSelector("input#txtCourseSearch");
    public By courseNameField = By.cssSelector("input#txtCourseName");
    public By subjectDropdown = By.cssSelector("select#courseSubject");

    public By gradeOrYearDropdown = By.cssSelector("select#courseGrade");
    public By selectCourseTeacherCheckbox = By.cssSelector("input#chkGetSelectedSubjectTeachers");

    public By courseTeacherDropdown = By.xpath("//div[@ng-model='courseCntrl.OnBehalfTeacher']");
    public By courseTeacher(String teacherName) {
        // available values: nada rehan, Test Teacher
        return By.xpath("//li[@class='ui-select-choices-group']//h5[@title='" + teacherName + "']");
    }
    public By overallAssessmentsOption = By.cssSelector("input#rdOverallAssessments");
    public By finalAssessmentOption = By.cssSelector("input#rdFinalAssessment");
    public By videosOption = By.cssSelector("input#rdVideo");
    public By noneOption = By.cssSelector("input#rdNone");

    public By createBtn = By.id("btnSaveAsDraftCourse");

    // Actions
    public void addACourse(String courseName, String subjectName, String grade, String teacherName) {
        click(addCourseBtn);
        setText(courseNameField, courseName);
        selectDataByText(subjectDropdown, subjectName);
        selectDataByText(gradeOrYearDropdown, grade);
        click(courseTeacherDropdown);;
        click(courseTeacher(teacherName));
        click(createBtn);
    }
    public void searchForACourse(String title) {
        setText(searchBar, title);
        setText(searchBar, String.valueOf(Keys.ENTER));
    }
}

