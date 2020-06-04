package org.fundacionjala.trello.TDD.team;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.entities.User;
import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import static org.fundacionjala.trello.driver.DriverFactory.getDriver;
import org.fundacionjala.trello.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateTeamTest {

    public static final String TRELLO_URL = "https://trello.com/login";
    private WebDriver driver;
    private FormPage<?> form;

    @BeforeMethod
    public final void setup() {
        Environment env = Environment.getInstance();
        driver = getDriver();
        driver.get(TRELLO_URL);
    }

    @AfterMethod
    public final void quit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void createTeamTest() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "New Team");
        data.put("type", "Education");
        User user = new User("user1");
        LoginPage page = new LoginPage(getDriver());
        PageObject actualPage = page.setCredentials(user.getEmail(), user.getPassword())
                .submit();
        form = actualPage.getHeader().createElement("team");
        form.fillForm(data);
        form.submit();
    }
}
