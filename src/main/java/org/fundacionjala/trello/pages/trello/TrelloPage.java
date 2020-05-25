package org.fundacionjala.trello.pages.trello;

import org.fundacionjala.trello.pages.menus.Header;
import org.openqa.selenium.WebDriver;

public abstract class TrelloPage extends PageObject {

    public TrelloPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * Gets Trello header component.
     *
     * @return Trello header.
     */
    public Header getHeader() {
        return new Header(driver);
    }
}
