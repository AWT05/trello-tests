package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.list.ListMenu;
import org.fundacionjala.trello.pages.list.ListPage;
import org.fundacionjala.trello.utils.AssertGroup;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public class ListStepDef {

    private BoardPage boardPage;
    private MenuBoard menuBoard;
    private ListPage listPage;
    private FormPage<?> form;
    private ListMenu listMenu;
    private Assertion assertGroup;

    public ListStepDef(final SharedDriver sharedDriver, final AssertGroup assertGroup) {
        this.boardPage = new BoardPage(getDriver());
        this.menuBoard = new MenuBoard(getDriver());
        this.listPage = new ListPage(getDriver());
        this.listMenu = new ListMenu(getDriver());
        this.assertGroup = assertGroup.getAssertGroup();
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
        assertGroup.assertTrue(stringListNames.contains(expectedData.get("name")));
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
    public void iArchiveTheList(final String listName) {
        menuBoard.closeMenuOptions();
        listPage.getListMenu(listName).archiveList();
    }

    /**
     * Validates that the list has been correctly archived.
     *
     * @param expectedListName the list name.
     */
    @Then("I verify that the {string} list has been archived")
    public void iVerifyThatTheListHasBeenArchived(final String expectedListName) {
        List<String> archivedLists = boardPage.displayMenu()
                .moreMenuOptions()
                .archivedItems()
                .switchItems()
                .archivedItemsList();
        assertGroup.assertTrue(archivedLists.contains(expectedListName));
    }
}
