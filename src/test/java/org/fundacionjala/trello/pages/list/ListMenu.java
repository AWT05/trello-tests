package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class ListMenu extends PageObject {

    public ListMenu(WebDriver driver) {
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
