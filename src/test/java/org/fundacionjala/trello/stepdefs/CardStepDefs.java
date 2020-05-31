package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.card.CardPage;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.list.ListPage;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CardStepDefs {

    private FormPage<?> form;
    private ListPage listPage;
    private CardPage cardPage;




    /**
     * Creates a card with specific data.
     *
     * @param data expected list data.
     */
    @When("I create a Card with:")
    public void iCreateAListWith(final Map<String, String> data) {
        form = cardPage.createNewCard();
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the list creation.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a card with:")
    public void iShouldHaveACardWith(final Map<String, String> expectedData) {
        List<String> cardNamesList = cardPage.getAllCardNames();
        assertTrue(cardNamesList.contains(expectedData.get("name")));
    }



}
