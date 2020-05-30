package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.list.ListForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public final class BoardPage extends PageObject {

    private static final String TITLE_TEXT = "div.mod-board-name > span";
    private static final String TITLE_INPUT = "div.mod-board-name > input";
    private static final String DELETE_CONTAINER = "p.delete-container a";
    private static final String DELETE_CONFIRM = "div.no-back input[value=\"Delete\"]";
    private static final String SHOW_MENU = "a.mod-show-menu";
    private static final String BOARD_HEADER = "div.board-header";
    private static final String BOARD_CANVAS = "#board";
    private static final String ADD_LIST = "div.js-add-list span.icon-add";

    @FindBy(css = BOARD_HEADER)
    private WebElement boardHeader;

    @FindBy(css = BOARD_CANVAS)
    private WebElement board;

    @FindBy(css = DELETE_CONTAINER)
    private WebElement deleteContainer;

    @FindBy(css = DELETE_CONFIRM)
    private WebElement deleteConfirm;

    @FindBy(css = TITLE_TEXT)
    private WebElement titleBoard;

    @FindBy(css = TITLE_INPUT)
    private WebElement titleBoardInput;

    @FindBy(css = SHOW_MENU)
    private WebElement showMenuButton;

    @FindBy(css = ADD_LIST)
    private WebElement addListIcon;

    public BoardPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return boardHeader.isDisplayed() && board.isDisplayed();
    }

    public String getTitle() {
        if (isDisplayed()) {
            return titleBoard.getText();
        }
        return "Error: Board not Found";
    }

    public MenuBoard displayMenu() {
        action.click(showMenuButton);
        return new MenuBoard(driver);
    }

    public void permanentlyDelete() {
        action.click(deleteContainer);
        action.click(deleteConfirm);
    }

    public FormPage<?> createNewList() {
        action.click(addListIcon);
        return new ListForm(driver);
    }

    public String getIdentifier() {
        String identifier = "";
        try {
            String currentUri = new URI(driver.getCurrentUrl()).getPath();
             identifier = Paths.get(currentUri).getName(1).toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return identifier;
    }
}
