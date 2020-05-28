package org.fundacionjala.trello.pages.menus;

import org.fundacionjala.trello.pages.core.WebObject;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public final class SideBar extends WebObject {

    private static final String CREATE_TEAM_BUTTON = "button[data-test-id=home-navigation-create-team-button]";

    @FindBy(css = CREATE_TEAM_BUTTON)
    private WebElement homeNavCreateTeamButton;

    public SideBar(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    /**
     * Gets Trello boards component.
     *
     * @return Trello boards component.
     */
    public BoardsPage getBoards() {
        return new BoardsPage(driver);
    }
}
