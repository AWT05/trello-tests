package org.fundacionjala.trello.pages.home;

import org.fundacionjala.trello.pages.menus.SideBar;
import org.fundacionjala.trello.pages.trello.TrelloPage;
import org.openqa.selenium.WebDriver;

public abstract class HomeTrelloPage extends TrelloPage {
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
