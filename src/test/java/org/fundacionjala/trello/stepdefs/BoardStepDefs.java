package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BoardStepDefs {

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
     * Validates access to a specific board.
     *
     * @param title board title.
     */
    @Then("{string} board page should be visible")
    public void boardPageShouldBeVisible(final String title) {
        board = new BoardPage(getChromeDriver());
        assertTrue(board.isDisplayed());
        assertEquals(board.getTitle(), title);
    }
}
