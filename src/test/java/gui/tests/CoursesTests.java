package gui.tests;

import org.junit.Assert;
import org.junit.Test;
import utils.JsonManager;

public class CoursesTests extends BaseTest{
    JsonManager data = new JsonManager("courses");
    @Test
    public void verifyAddingANewCourse(){
        loginPage.login(data.getTestData("credentials.username"), data.getTestData("credentials.password"));
        navigator.NavigateToCoursesPage();
        coursesPage.addACourse(
                data.getTestData("course.courseName"),
                data.getTestData("course.subjectName"),
                data.getTestData("course.grade"),
                data.getTestData("course.teacherName"));
        navigator.NavigateToCoursesPage();
        coursesPage.searchForACourse(data.getTestData("course.courseName"));
        Assert.assertEquals(basePage.getContent(coursesPage.courseTitle), data.getTestData("course.courseName"));
    }
}
