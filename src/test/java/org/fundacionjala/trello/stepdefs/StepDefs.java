package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.entities.User;
import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.login.LoginPage;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class StepDefs {

    private Context context;
    private LoginPage loginPage;

    public StepDefs(final SharedDriver sharedDriver, final Context context) {
        this.context = context;
        loginPage = new LoginPage(getDriver());
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
        context.saveUser(user);
    }
}
