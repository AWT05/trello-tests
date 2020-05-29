package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public final class BoardStepDefs {

    private BoardPage board;
    private final Context context;

    public BoardStepDefs(final Context context) {
        this.context = context;
    }

    @Then("{string} board page should be visible")
    public void boardPageShouldBeVisible(String title) {
        board = new BoardPage(getChromeDriver());
        assertTrue(board.isDisplayed());
        assertEquals(board.getTitle(), title);
    }
}
