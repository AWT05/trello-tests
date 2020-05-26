package org.fundacionjala.trello.pages.home;

import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.menus.SideBar;
import org.openqa.selenium.WebDriver;

public abstract class HomeTrelloPage extends PageObject {
    public HomeTrelloPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * Gets Trello side bar component.
     *
     * @return Trello side bar.
     */
    public SideBar getSideBar() {
        return new SideBar(driver);
    }
}
