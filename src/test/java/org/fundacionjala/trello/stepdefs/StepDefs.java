package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.context.UserTrello;
import org.fundacionjala.trello.pages.IIdentifier;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.trello.pages.login.LoginPage;
import org.fundacionjala.trello.utils.CommonValidations;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class StepDefs {

    private ContextTrello context;
    private LoginPage loginPage;

    public StepDefs(final SharedDriver sharedDriver, final ContextTrello context) {
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
        UserTrello user = new UserTrello(userAccount);
        PageObject actualPage = loginPage.setCredentials(user.getEmail(), user.getPassword()).submit();
        context.saveActualPage(actualPage);
        context.saveUser(user);
    }

    @ParameterType("board|team")
    public EndPointsEnum element(final String element) {
        return CommonValidations.verifyEndPointEnum(element);
    }

    /**
     * Saves the id of the element created.
     *
     * @param element value used to save the Id.
     */
    @When("I save the identifier of the {element} created")
    public void savesIDsInContext(final EndPointsEnum element) {
        if (context.getActualPage() instanceof IIdentifier) {
            IIdentifier item = (IIdentifier) context.getActualPage();
            context.getUser().saveIds(element, item.getIdentifier());
        }
    }
}
