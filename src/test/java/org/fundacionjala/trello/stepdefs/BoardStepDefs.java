package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.menus.MenuBoards;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BoardStepDefs {

    private final BoardsPage boardsHome;
    private MenuBoards menuBoards;
    private BoardPage board;
    private final ContextTrello context;

    public BoardStepDefs(final SharedDriver sharedDriver, final ContextTrello context) {
        this.context = context;
        board = new BoardPage(getDriver());
        menuBoards = new MenuBoards(getDriver());
        boardsHome = new BoardsPage(getDriver());
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
        assertEquals(actualData.get("title"), board.getTitle());
    }

    /**
     * Validates access to a specific board.
     *
     * @param title board title.
     */
    @Then("{string} board page should be visible")
    public void boardPageShouldBeVisible(final String title) {
        assertTrue(board.isDisplayed());
        assertEquals(board.getTitle(), title);
    }
}
