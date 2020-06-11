package org.fundacionjala.trello.pages.menus;

import org.fundacionjala.core.ui.pages.WebObject;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.pages.board.BoardForm;
import org.fundacionjala.trello.pages.team.TeamForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class Header extends WebObject {

    private static final String CREATE_MENU_BUTTON = "button[data-test-id=\"header-create-menu-button\"]";
    private static final String CREATE_BOARD_BUTTON = "button[data-test-id=\"header-create-board-button\"]";
    private static final String CREATE_TEAM_BUTTON = "button[data-test-id=\"header-create-team-button\"]";
    private static final String BOARDS_MENU_BUTTON = "button[data-test-id=\"header-boards-menu-button\"]";
    private static final String PROFILE_BUTTON = "button[data-test-id= 'header-member-menu-button']";

    @FindBy(css = CREATE_MENU_BUTTON)
    private WebElement creationButton;

    @FindBy(css = CREATE_BOARD_BUTTON)
    private WebElement createBoardButton;

    @FindBy(css = CREATE_TEAM_BUTTON)
    private WebElement createTeamButton;

    @FindBy(css = BOARDS_MENU_BUTTON)
    private WebElement headerMenuBoards;

    @FindBy(css = PROFILE_BUTTON)
    private WebElement profileButton;

    public Header(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return creationButton.isDisplayed();
    }

    public FormPage<?> createElement(final String entity) {
        action.click(creationButton);
        switch (entity) {
            case "board":
                action.click(createBoardButton);
                return new BoardForm(driver);
            case "team":
                action.click(createTeamButton);
                return new TeamForm(driver);
            default:
                throw new IllegalArgumentException(String.format("Invalid entity: <%s>", entity));
        }
    }

    public MenuBoards getMenuBoards() {
        action.waitForPageLoadComplete();
        action.waitForVisibility(headerMenuBoards);
        action.click(headerMenuBoards);
        return new MenuBoards(driver);
    }

    public MenuProfile getMenuProfile() {
        action.waitForVisibility(profileButton);
        action.click(profileButton);
        return new MenuProfile(driver);
    }
}
