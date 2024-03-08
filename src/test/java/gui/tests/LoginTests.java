package gui.tests;

import org.junit.Assert;
import org.junit.Test;
import utils.JsonManager;

public class LoginTests extends BaseTest{
    JsonManager data = new JsonManager("administration");
    @Test
    public void loginWithValidCredentials(){
        loginPage.login(
                data.getTestData("credentials.username"),
                data.getTestData("credentials.password"));

        Assert.assertEquals(
                basePage.getContent(administrationPage.tenantDisplayName),
                data.getTestData("content.tenantDisplayName"));
    }
}
