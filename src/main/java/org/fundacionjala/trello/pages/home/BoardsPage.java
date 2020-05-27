package org.fundacionjala.trello.pages.home;

import org.openqa.selenium.WebDriver;

public final class BoardsPage extends HomePage {
    public BoardsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}