package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.board.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TeamSection extends Section{
    public TeamSection(WebDriver driver, String name) {
        super(driver);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<WebElement> getBoards() {
        return null;
    }

    @Override
    public BoardPage getBoard(String name) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
