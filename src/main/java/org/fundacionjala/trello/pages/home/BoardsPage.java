package org.fundacionjala.trello.pages.home;

import org.fundacionjala.trello.pages.WebPage;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPage extends WebPage {

    public BoardsPage(WebDriver driver) {
        super(driver);
    }

    public BoardPage getBoard(String boardName) {
        WebElement boardElement = driver.findElement(By.cssSelector("div[title=".concat(boardName).concat("]")));
        action.clickButton(boardElement);
        return new BoardPage(driver);
    }
}
