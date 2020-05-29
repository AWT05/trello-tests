package org.fundacionjala.trello.pages.home;

import org.fundacionjala.trello.pages.board.BoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class BoardsPage extends HomePage {
    public BoardsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
