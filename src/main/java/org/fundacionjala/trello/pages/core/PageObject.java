package org.fundacionjala.trello.pages.core;

import org.fundacionjala.trello.pages.menus.Header;
import org.openqa.selenium.WebDriver;

/**
 * Page web element with header.
 */
public abstract class PageObject extends WebObject {

    public PageObject(final WebDriver driver) {
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
