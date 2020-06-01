package org.fundacionjala.trello.TDD.team;

import org.fundacionjala.trello.config.Environment;
import org.fundacionjala.trello.driver.DriverFactory;
import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import org.fundacionjala.trello.entities.User;
import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class CreateTeamTest {

    public static final String TRELLO_URL = "https://trello.com/login";
    private WebDriver driver;
    private FormPage<?> form;

    @BeforeMethod
    public final void setup() {
        Environment env = Environment.getInstance();
        DriverFactory.resizeScreen(env.getBrowserWidth(), env.getBrowserHeight());
        driver.get(TRELLO_URL);
    }

    @AfterMethod
    public final void quit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void createTeamTest(final Map<String, String> data) {
        User user = new User("user1");
        LoginPage page = new LoginPage(getChromeDriver());
        PageObject actualPage = page.setCredentials(user.getEmail(), user.getPassword())
                .submit();
        form = actualPage.getHeader().createElement("team");
        form.fillForm(data);
        form.submit();
    }
}
