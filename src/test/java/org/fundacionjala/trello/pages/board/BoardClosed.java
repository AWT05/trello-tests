package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class BoardClosed extends PageObject {
    public BoardClosed(final WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        return false;
    }
}
