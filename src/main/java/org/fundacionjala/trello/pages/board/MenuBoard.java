package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.core.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MenuBoard extends WebObject {

    private static final String OPEN_MORE = "li a.js-open-more";
    private static final String CLOSE_MENU = "a.board-menu-header-close-button";

    @FindBy(css = OPEN_MORE)
    private WebElement moreButton;

    @FindBy(css = CLOSE_MENU)
    private WebElement closeMenuButton;

    public MenuBoard(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return moreButton.isDisplayed();
    }

    public MenuMoreBoard moreMenuOptions() {
        action.click(moreButton);
        return new MenuMoreBoard(driver);
    }

    public BoardPage closeMenuOptions() {
        action.click(closeMenuButton);
        return new BoardPage(driver);
    }
}
