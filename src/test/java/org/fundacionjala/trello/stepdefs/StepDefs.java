package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.entities.User;
import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.login.LoginPage;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public final class StepDefs {

    private Context context;
    private LoginPage loginPage;

    public StepDefs(final Context context) {
        this.context = context;
        loginPage = new LoginPage(getChromeDriver());
    }

    /**
     * Logins in trello with Atlassian account.
     *
     * @param userAccount keyword to get an user.
     */
    @Given("I log in with my Atlassian account as {string}")
    public void loginAtlassianAccount(final String userAccount) {
        User user = new User(userAccount);
        PageObject actualPage = loginPage.loginWithAtlassian(user.getEmail())
                .setPassword(user.getPassword())
                .submit();
        context.saveActualPage(actualPage);
    }

    /**
     * Logins in trello page.
     *
     * @param userAccount keyword to get an user.
     */
    @When("I log in with my Trello account as {string}")
    public void iAmLogInUsingTheUiAs(final String userAccount) {
        User user = new User(userAccount);
        PageObject actualPage = loginPage.setCredentials(user.getEmail(), user.getPassword()).submit();
        context.saveActualPage(actualPage);
    }
}
