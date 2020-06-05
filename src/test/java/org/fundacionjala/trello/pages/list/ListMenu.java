package org.fundacionjala.trello.pages.list;

import org.fundacionjala.core.ui.pages.WebObject;
import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListMenu extends PageObject {

    private static final String LIST_ACTIONS_TITTLE = "span.pop-over-header-title";
    private static final String ARCHIVE_LIST = "a.js-close-list";

    @FindBy(css = LIST_ACTIONS_TITTLE)
    private WebElement actionsTittle;

    @FindBy(css = ARCHIVE_LIST)
    private WebElement archiveListButton;

    public ListMenu(WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        action.waitElementVisible(actionsTittle);
        return actionsTittle.isDisplayed();
    }

    public void archiveList(){
        action.waitElementVisible(archiveListButton);
        action.click(archiveListButton);
    }
}
