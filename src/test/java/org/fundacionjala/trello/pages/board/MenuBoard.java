package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.pages.WebObject;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

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
        // To do: explicit wait
        return moreButton.isDisplayed();
    }

    public MenuMoreBoard moreMenuOptions() {
        action.click(moreButton);
        return new MenuMoreBoard(driver);
    }

    public BoardPage closeMenuOptions() {
        Environment env = Environment.getInstance();
        try {
            wait.withTimeout(env.getReducedTime(), TimeUnit.SECONDS);
            action.waitForPageLoadComplete();
            action.waitForVisibility(closeMenuButton);
            isDisplayed();
            action.click(closeMenuButton);
        } catch (ElementNotInteractableException | TimeoutException ignored) {
        } finally {
            wait.withTimeout(env.getExplicitTimeWait(), TimeUnit.SECONDS);
        }
        return new BoardPage(driver);
    }
}
