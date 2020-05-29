package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.menus.MenuBoards;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertEquals;

public final class BoardStepDefs {

    private MenuBoards menuBoards;
    private BoardPage board;
    private final Context context;

    public BoardStepDefs(final Context context) {
        this.context = context;
    }

    /**
     * Validates the creation of the board with the given data.
     *
     * @param actualData expected data to validate the creation.
     */
    @Then("I should have a board created with the following data")
    public void validateCreationWithData(final Map<String, String> actualData) {
        board = new BoardPage(getChromeDriver());
        assertEquals(actualData.get("title"), board.getTitle());
    }

    /**
     * Opens a board inside personal boards
     *
     * @param boardName to open a specified board
     */
    @And("I open the {string} board")
    public void iOpenTheBoard(String boardName) {
        menuBoards = new MenuBoards(getChromeDriver());
        menuBoards.goToBoardOnPersonalBoards(boardName);
    }
}
