package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.pages.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MenuMoreBoard extends WebObject {

    private static final String LINK_CLOSE_BOARD = "a.board-menu-navigation-item-link.js-close-board";
    private static final String CONFIRM_CLOSE = "div.pop-over input[value=\"Close\"]";
    private static final String ARCHIVED_ITEMS = "span.icon-sm.icon-archive";

    @FindBy(css = LINK_CLOSE_BOARD)
    private WebElement closeBoard;

    @FindBy(css = CONFIRM_CLOSE)
    private WebElement confirmClose;

    @FindBy(css = ARCHIVED_ITEMS)
    private WebElement archivedItemsButton;

    public MenuMoreBoard(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public BoardPage closeBoard() {
        action.click(closeBoard);
        action.click(confirmClose);
        return new BoardPage(driver);
    }

    public ArchivedItemsBoard archivedItems() {
        action.waitElementVisible(archivedItemsButton);
        action.click(archivedItemsButton);
        return new ArchivedItemsBoard(driver);
    }
}
