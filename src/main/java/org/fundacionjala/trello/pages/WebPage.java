package org.fundacionjala.trello.pages;

import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.WebDriver;

public class WebPage extends BasePage {
    public WebPage(WebDriver driver) {
        super(driver);
    }

    public BoardsPage getHomeBoards(){
        return new BoardsPage(driver);
    }
}
