package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.menus.MenuBoards;
import org.fundacionjala.trello.utils.AssertGroup;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public class BoardStepDefs {

    private final BoardsPage boardsHome;
    private final MenuBoard menuIntoBoard;
    private MenuBoards menuBoards;
    private BoardPage board;
    private final ContextTrello context;
    private Assertion assertGroup;

    public BoardStepDefs(final SharedDriver sharedDriver, final ContextTrello context, final AssertGroup assertGroup) {
        this.context = context;
        board = new BoardPage(getDriver());
        menuBoards = new MenuBoards(getDriver());
        menuIntoBoard = new MenuBoard(getDriver());
        boardsHome = new BoardsPage(getDriver());
        this.assertGroup = assertGroup.getAssertGroup();
    }

    /**
     * Navigates to Boards Home page.
     */
    @When("I navigate to boards home page")
    public void navigateToBoardsPage() {
        context.saveActualPage(boardsHome.goToPage(context.getUser().getUsername()));
    }

    /**
     * Opens a board inside personal boards.
     *
     * @param boardName to open a specified board.
     */
    @When("I open the {string} board")
    public void iOpenTheBoard(final String boardName) {
        menuBoards.openPersonalBoard(boardName);
    }

    /**
     * Opens a board inside a team.
     *
     * @param boardName String name of a specific board.
     * @param teamName  String name of a specific team.
     */
    @When("I select {string} board form the {string} team")
    public void iSelectBoardFormTheTeam(final String boardName, final String teamName) {
        menuBoards.openTeamBoard(teamName, boardName);
    }

    /**
     * Validates the creation of the board with the given data.
     *
     * @param actualData expected data to validate the creation.
     */
    @Then("I should have a board created with the following data")
    public void validateCreationWithData(final Map<String, String> actualData) {
        assertGroup.assertEquals(actualData.get("title"), board.getTitle());
    }

    /**
     * Validates access to a specific board.
     *
     * @param title board title.
     */
    @Then("{string} board page should be visible")
    public void boardPageShouldBeVisible(final String title) {
        assertGroup.assertTrue(board.isDisplayed());
        assertGroup.assertEquals(board.getTitle(), title);
    }

    /**
     * Opens team from boards menu of header.
     *
     * @param teamName name of the team to open.
     */
    @When("I open the {string} team")
    public void selectTeam(final String teamName) {
        menuBoards.goToTeamPage(teamName);
    }

    /**
     * Step to close the Board menu.
     */
    @Given("I close the board menu")
    public void iCloseTheBoardMenu() {
        menuIntoBoard.closeMenuOptions();
    }

    /**
     * Adds members to the board created.
     *
     * @param members List of member to be added.
     */
    @When("I invite the following member(s)")
    public void iInviteTheFollowingMembers(final List<String> members) {
        board.addMembersToInvite(members)
                .sendInvitation();
    }
}
