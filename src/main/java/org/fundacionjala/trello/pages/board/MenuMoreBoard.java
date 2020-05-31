package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.core.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MenuMoreBoard extends WebObject {

    private static final String LINK_CLOSE_BOARD = "a.board-menu-navigation-item-link.js-close-board";
    private static final String CONFIRM_CLOSE = "div.pop-over input[value=\"Close\"]";

    @FindBy(css = LINK_CLOSE_BOARD)
    private WebElement closeBoard;

    @FindBy(css = CONFIRM_CLOSE)
    private WebElement confirmClose;

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
}
