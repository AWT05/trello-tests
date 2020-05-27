package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.core.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MenuBoard extends WebObject {

    private static final String OPEN_MORE = "li a.js-open-more";

    @FindBy(css = OPEN_MORE)
    private WebElement moreButton;

    public MenuBoard(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return moreButton.isDisplayed();
    }

    public MenuMoreBoard moreMenuOptions() {
        click(moreButton);
        return new MenuMoreBoard(driver);
    }
}
