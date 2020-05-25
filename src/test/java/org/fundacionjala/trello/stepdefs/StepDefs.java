package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.entities.User;
import org.fundacionjala.trello.home.BoardsPage;
import org.fundacionjala.trello.pages.login.LoginPage;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public final class StepDefs {

    private Context context;

    public StepDefs(final Context context) {
        this.context = context;
    }

    @Given("I am logged with my valid credentials as {string}")
    public void loginValidCredentials(final String userAccount) {
        User user = new User(userAccount);
        LoginPage page = new LoginPage(getChromeDriver());
        BoardsPage actualPage = page.loginWithAtlassian(user.getEmail())
                .setPassword(user.getPassword())
                .submit();
        context.saveActualPage(actualPage);
    }
}
