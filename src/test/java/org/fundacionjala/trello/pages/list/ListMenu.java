package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class ListMenu extends PageObject {

    private static final String LIST_ACTIONS_TITTLE = "span.pop-over-header-title";
    private static final String ARCHIVE_LIST = "a.js-close-list";

    @FindBy(css = LIST_ACTIONS_TITTLE)
    private WebElement actionsTittle;

    @FindBy(css = ARCHIVE_LIST)
    private WebElement archiveListButton;

    public ListMenu(final WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        action.waitForVisibility(actionsTittle);
        return actionsTittle.isDisplayed();
    }

    public void archiveList() {
        action.waitForVisibility(archiveListButton);
        action.click(archiveListButton);
    }
}
