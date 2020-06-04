package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class BoardHooks {

    private static final int CLEAN_CONTEXT_ORDER_BOARD_UI = 20;
    private static final int CLEAN_CONTEXT_ORDER_BOARD = 21;
    private final ContextTrello context;
    private final RequestManager requestManager;

    public BoardHooks(final ContextTrello context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Delete a Board if it was created by UI.
     */
    @After(value = "@deleteBoardUi", order = CLEAN_CONTEXT_ORDER_BOARD_UI)
    public void deleteBoardByUI() {
        BoardPage board = new BoardPage(getDriver());
        MenuBoard menuBoard = new MenuBoard(getDriver());
        if (!board.isDisplayed()) {
            return;
        }
        if (!menuBoard.isDisplayed()) {
            menuBoard = board.displayMenu();
        }
        menuBoard.moreMenuOptions().closeBoard().permanentlyDelete();
    }

    /**
     * Delete a Board if it was created by API.
     */
    @After(value = "@deleteBoard", order = CLEAN_CONTEXT_ORDER_BOARD)
    public void deleteBoardByApi() {
        context.getUsers().forEach(user -> {
            requestManager.setApiCredentials(user.getKeyword());
            user.getIdsByKey(BOARD).forEach(id -> requestManager
                    .init(context)
                    .delete(BOARD.getEndPoint().concat(id)));
        });
    }
}
