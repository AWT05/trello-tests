package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public final class BoardHooks {

    private static final int CLEAN_CONTEXT_ORDER_VALUE_BOARD = 20;
    private final Context context;
    private final RequestManager requestManager;

    public BoardHooks(final Context context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Delete a Board if it was created.
     */
    @After(value = "@deleteBoard", order = CLEAN_CONTEXT_ORDER_VALUE_BOARD)
    public void deleteBoard() {
        deleteByApi();
        deleteByUI();
    }

    private void deleteByUI() {
        BoardPage board = new BoardPage(getChromeDriver());
        MenuBoard menuBoard = new MenuBoard(getChromeDriver());
        if (!board.isDisplayed()) {
            return;
        }
        if (!menuBoard.isDisplayed()) {
            menuBoard = board.displayMenu();
        }
        menuBoard.moreMenuOptions().closeBoard().permanentlyDelete();
    }

    private void deleteByApi() {
        context.getIdsByKey(BOARD)
                .forEach(id -> requestManager.init(context).delete(BOARD.getEndPoint().concat(id)));
    }
}
