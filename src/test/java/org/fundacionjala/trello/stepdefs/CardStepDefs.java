package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.card.CardPage;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.list.ListPage;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertTrue;

public class CardStepDefs {

    private final Context context;
    private FormPage<?> form;
    private BoardPage boardPage;
    private MenuBoard menuBoard;
    private ListPage listPage;
    private CardPage cardPage;

    public CardStepDefs(final Context context) {
        this.context = context;
        menuBoard = new MenuBoard(getChromeDriver());
        listPage = new ListPage(getChromeDriver());
        cardPage = new CardPage(getChromeDriver());
    }

    /**
     * Creates a card with specific data.
     *
     * @param listName expected name of the list where card will be created.
     * @param data expected card data.
     */
    @When("In the {string} list I create a Card with:")
    public void iCreateCardWith(final String listName, final Map<String, String> data) {
        if (menuBoard.isDisplayed()) {
            menuBoard.closeMenuOptions();
        }
        form = listPage.createNewCard(listName);
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the card creation.
     *
     * @param listName expected list name where to find the card.
     * @param expectedData expected data to validate the creation.
     */
    @Then("In the {string} I should have a card with:")
    public void iShouldHaveACardWith(final String listName, final Map<String, String> expectedData) {
        List<String> cardNamesList = cardPage.getAllCardNames(listName);
        assertTrue(cardNamesList.contains(expectedData.get("name")));
    }
}