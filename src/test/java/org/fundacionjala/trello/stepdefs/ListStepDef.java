package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.list.ListPage;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertTrue;

public class ListStepDef {

    private final ContextTrello context;
    private BoardPage boardPage;
    private MenuBoard menuBoard;
    private ListPage listPage;
    private FormPage<?> form;

    public ListStepDef(final ContextTrello context) {
        this.context = context;
        boardPage = new BoardPage(getChromeDriver());
        menuBoard = new MenuBoard(getChromeDriver());
        listPage = new ListPage(getChromeDriver());
    }

    /**
     * Creates a list with specific data.
     *
     * @param data expected list data.
     */
    @When("I create a List with:")
    public void iCreateAListWith(final Map<String, String> data) {
        if (menuBoard.isDisplayed()) {
            menuBoard.closeMenuOptions();
        }
        form = boardPage.createNewList();
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the list creation.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a list created with:")
    public void iShouldHaveAListCreatedWith(final Map<String, String> expectedData) {
        List<String> stringListNames = listPage.getAllListsNames();
        assertTrue(stringListNames.contains(expectedData.get("name")));
    }
}
