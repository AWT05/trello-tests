package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.core.context.Context;
import static org.fundacionjala.core.ui.DriverFactory.getChromeDriver;
import org.fundacionjala.core.entities.User;
import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.trello.pages.login.LoginPage;

public final class StepDefs {

    private Context context;
    private LoginPage loginPage;

    public StepDefs(final Context context) {
        this.context = context;
        loginPage = new LoginPage(getChromeDriver());
    }

    /**
     * Logins in trello page.
     *
     * @param userAccount keyword to get an user.
     */
    @Given("I log in with my Trello account as {string}")
    public void iLogInWithTrelloAccountAs(final String userAccount) {
        User user = new User(userAccount);
        PageObject actualPage = loginPage.setCredentials(user.getEmail(), user.getPassword()).submit();
        context.saveActualPage(actualPage);
    }
}
