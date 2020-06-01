package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.menus.MenuBoards;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BoardStepDefs {

    private MenuBoards menuBoards;
    private BoardPage board;
    private final ContextTrello context;

    public BoardStepDefs(final ContextTrello context) {
        this.context = context;
        board = new BoardPage(getChromeDriver());
        menuBoards = new MenuBoards(getChromeDriver());
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
