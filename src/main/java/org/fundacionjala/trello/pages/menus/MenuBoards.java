package org.fundacionjala.trello.pages.menus;

import org.fundacionjala.trello.pages.board.BoardClosed;
import org.fundacionjala.trello.pages.board.BoardForm;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.core.WebObject;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBoards extends WebObject {

    private static final String FIND_BOARDS = "input[data-test-id='header-boards-menu-search']";
    private static final String CREATE_BOARD = "button[data-test-id='header-boards-menu-create-board']";
    private static final String CLOSED_BOARDS = "button[data-test-id='header-boards-menu-open-closed']";

    @FindBy(css = FIND_BOARDS)
    private WebElement findBoards;

    @FindBy(css = CREATE_BOARD)
    private WebElement createBoardButton;

    @FindBy(css = CLOSED_BOARDS)
    private WebElement closedBoardsButton;

    public MenuBoards(WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        return findBoards.isDisplayed();
    }

    public BoardPage goToBoardOnPersonalBoards(String boardName) {
        WebElement boardElement = driver.findElement(By
                .xpath("//span[@name='board']/parent::span/parent::div/following-sibling::div//" +
                        "div[contains(text(), '".concat(boardName).concat("')]")));
        boardElement.click();
        return new BoardPage(driver);
    }

    public BoardPage goToBoardOnTeamBoards(String teamName, String boardName) {
        WebElement boardElement = driver.findElement(By
                .xpath("//span[text()='".concat(teamName).concat("']/ancestor::a/parent::div/" +
                        "following-sibling::div//div[contains(text(), '".concat(boardName).concat("')]"))));
        boardElement.click();
        return new BoardPage(driver);
    }

    public FormPage<?> createBoard() {
        click(createBoardButton);
        return new BoardForm(driver);
    }

    public BoardClosed goToClosedBoards(){
        click(closedBoardsButton);
        return new BoardClosed(driver);
    }
}
