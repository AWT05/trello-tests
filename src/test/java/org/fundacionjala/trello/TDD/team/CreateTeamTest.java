package org.fundacionjala.trello.TDD.team;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.DriverFactory;
import static org.fundacionjala.core.ui.DriverFactory.getChromeDriver;
import org.fundacionjala.core.entities.User;
import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.core.ui.pages.forms.FormPage;
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
        DriverFactory.resizeScreen(env.getBrowserWidth(), env.getBrowserHeight());
        driver = getChromeDriver();
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
        LoginPage page = new LoginPage(getChromeDriver());
        PageObject actualPage = page.setCredentials(user.getEmail(), user.getPassword())
                .submit();
        form = actualPage.getHeader().createElement("team");
        form.fillForm(data);
        form.submit();
    }
}
