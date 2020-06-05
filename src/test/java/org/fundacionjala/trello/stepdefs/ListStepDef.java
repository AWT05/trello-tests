package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.list.ListMenu;
import org.fundacionjala.trello.pages.list.ListPage;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertTrue;

public class ListStepDef {

    private BoardPage boardPage;
    private MenuBoard menuBoard;
    private ListPage listPage;
    private FormPage<?> form;
    private ListMenu listMenu;

    public ListStepDef(final SharedDriver sharedDriver) {
        boardPage = new BoardPage(getDriver());
        menuBoard = new MenuBoard(getDriver());
        listPage = new ListPage(getDriver());
        listMenu = new ListMenu(getDriver());
    }

    /**
     * Creates a list with specific data.
     *
     * @param data expected list data.
     */
    @When("I create a List with:")
    public void iCreateAListWith(final Map<String, String> data) {
        menuBoard.closeMenuOptions();
        form = boardPage.createNewList();
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the list creation.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a list (created)(updated) with:")
    public void shouldHaveAListCreatedUpdated(final Map<String, String> expectedData) {
        List<String> stringListNames = listPage.getAllListsNames();
        assertTrue(stringListNames.contains(expectedData.get("name")));
    }

    /**
     * Updates a list with specific data.
     *
     * @param listName to set the list name.
     * @param data     expected list data.
     */
    @When("I update the {string} List with:")
    public void updateTheList(final String listName, final Map<String, String> data) {
        menuBoard.closeMenuOptions();
        form = boardPage.updateList(listName);
        form.fillForm(data);
        form.submit();
    }

    /**
     * Archives a list by its name.
     *
     * @param listName to archive.
     */
    @When("I archive the {string} list")
    public void iArchiveTheList(String listName) {
        menuBoard.closeMenuOptions();
        listPage.getListMenu(listName).archiveList();
    }

    /**
     * Validates that the list has been correctly archived.
     *
     * @param expectedListName the list name.
     */
    @Then("I verify that the {string} list has been archived")
    public void iVerifyThatTheListHasBeenArchived(String expectedListName) {
        List<String> archivedLists = boardPage.displayMenu()
                .moreMenuOptions()
                .archivedItems()
                .switchItems()
                .ArchivedItemList();
        assertTrue(archivedLists.contains(expectedListName));
    }
}
