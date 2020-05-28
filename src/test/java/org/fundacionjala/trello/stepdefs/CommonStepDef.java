package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.entities.User;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.login.LoginPage;
import org.fundacionjala.trello.webdriver.ManageDriver;

public class CommonStepDef {

    private Context context;

    public CommonStepDef(final Context context) {
        this.context = context;
    }

    @When("I log in as {string}")
    public void iAmLogInUsingTheUiAs(final String userAccount) {
        User user = new User(userAccount);
        LoginPage page = new LoginPage(ManageDriver.getInstance().getWebDriver());
        BoardsPage actualPage = page.setCredentials(user.getEmail(),user.getPassword()).submit();
        context.saveActualPage(actualPage);
    }
}
