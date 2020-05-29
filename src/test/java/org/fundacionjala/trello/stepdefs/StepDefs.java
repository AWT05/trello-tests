package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.trello.context.Context;
import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import org.fundacionjala.trello.entities.User;
import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.login.LoginPage;

public final class StepDefs {

    private Context context;

    public StepDefs(final Context context) {
        this.context = context;
    }

    /**
     * Logins in trello with Atlassian account.
     *
     * @param userAccount keyword to get an user.
     */
    @Given("I log in with my Atlassian account as {string}")
    public void loginAtlassianAccount(final String userAccount) {
        User user = new User(userAccount);
        LoginPage page = new LoginPage(getChromeDriver());
        PageObject actualPage = page.loginWithAtlassian(user.getEmail())
                .setPassword(user.getPassword())
                .submit();
        context.saveActualPage(actualPage);
    }

    /**
     * Logs in trello.
     *
     * @param userAccount keyword to get a user.
     */
    @Given("I log in with my Trello account as {string}")
    public void iLogInWithMyTrelloAccountAs(final String userAccount) {
        User user = new User(userAccount);
        LoginPage page = new LoginPage(getChromeDriver());
        PageObject actualPage = page.setCredentials(user.getEmail(), user.getPassword()).submit();
        context.saveActualPage(actualPage);
    }
}
