package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public class BoardHooks {

    private static final int CLEAN_CONTEXT_ORDER_VALUE_BOARD = 20;

    @After(value = "@deleteBoard",order = CLEAN_CONTEXT_ORDER_VALUE_BOARD)
    public void deleteBoard() {
        BoardPage board = new BoardPage(getChromeDriver());
        MenuBoard menuBoard = new MenuBoard(getChromeDriver());
        if (!board.isDisplayed() ) {
            return;
        }
        if (!menuBoard.isDisplayed()) {
            menuBoard = board.displayMenu();
        }
        menuBoard.moreMenuOptions().closeBoard().permanentlyDelete();
    }
}
