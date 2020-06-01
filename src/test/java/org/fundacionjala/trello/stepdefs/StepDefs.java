package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.context.UserTrello;
import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.login.LoginPage;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public final class StepDefs {

    private ContextTrello context;
    private LoginPage loginPage;

    public StepDefs(final ContextTrello context) {
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
        UserTrello user = new UserTrello(userAccount);
        PageObject actualPage = loginPage.setCredentials(user.getEmail(), user.getPassword()).submit();
        context.saveActualPage(actualPage);
        context.saveUser(user);
    }
}
