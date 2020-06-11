package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.card.CardPage;
import org.fundacionjala.trello.pages.list.ListPage;
import org.fundacionjala.trello.utils.AssertGroup;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public class CardStepDefs {

    private FormPage<?> form;
    private MenuBoard menuBoard;
    private ListPage listPage;
    private CardPage cardPage;
    private Assertion assertGroup;

    public CardStepDefs(final SharedDriver sharedDriver, final AssertGroup assertGroup) {
        this.menuBoard = new MenuBoard(getDriver());
        this.listPage = new ListPage(getDriver());
        this.cardPage = new CardPage(getDriver());
        this.assertGroup = assertGroup.getAssertGroup();
    }

    /**
     * Creates a card with specific data.
     *
     * @param listName expected name of the list where card will be created.
     * @param data     expected card data.
     */
    @When("I create a card on {string} list with:")
    public void iCreateCardWith(final String listName, final Map<String, String> data) {
        menuBoard.closeMenuOptions();
        form = listPage.createNewCard(listName);
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the card creation.
     *
     * @param listName     expected list name where to find the card.
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a card on {string} list with:")
    public void iShouldHaveACardWith(final String listName, final Map<String, String> expectedData) {
        List<String> cardNamesList = cardPage.getAllCardNames(listName);
        assertGroup.assertTrue(cardNamesList.contains(expectedData.get("name")));
    }
}
