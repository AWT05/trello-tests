package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.board.BoardForm;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.core.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Section extends WebObject {

    public Section(WebDriver driver) {
        super(driver);
    }

    public abstract String getName();

    public abstract List<WebElement> getBoards();

    public abstract BoardPage getBoard(String name);

    public abstract BoardForm createBoard();
}
