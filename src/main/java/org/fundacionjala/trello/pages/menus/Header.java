package org.fundacionjala.trello.pages.menus;

import org.fundacionjala.trello.pages.board.BoardForm;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.core.WebObject;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class Header extends WebObject {

    private static final String CREATE_MENU_BUTTON = "button[data-test-id=\"header-create-menu-button\"]";
    private static final String CREATE_BOARD_BUTTON = "button[data-test-id=\"header-create-board-button\"]";
    private static final String BOARDS_MENU_BUTTON = "button[data-test-id=\"header-boards-menu-button\"]";

    @FindBy(css = CREATE_MENU_BUTTON)
    private WebElement creationButton;

    @FindBy(css = CREATE_BOARD_BUTTON)
    private WebElement createBoardButton;

    @FindBy(css = BOARDS_MENU_BUTTON)
    private WebElement headerMenuBoards;

    public Header(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return creationButton.isDisplayed();
    }

    public FormPage<?> createElement(final String entity) {
        click(creationButton);
        switch (entity) {
            case "board":
                click(createBoardButton);
                return new BoardForm(driver);
            default:
                throw new IllegalArgumentException(String.format("Invalid entity: <%s>", entity));
        }
    }

    public MenuBoards getMenuBoards() {
        click(headerMenuBoards);
        return new MenuBoards(driver);
    }
}
