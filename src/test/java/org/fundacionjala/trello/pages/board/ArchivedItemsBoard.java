package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public final class ArchivedItemsBoard extends PageObject {

    private static final String ARCHIVE_TITTLE = "h3.board-menu-header-title";
    private static final String SWITCH_BUTTON = "a.archive-controls-switch";
    private static final String ARCHIVED_LIST = "div.item-name";

    @FindBy(css = ARCHIVE_TITTLE)
    private WebElement tittle;

    @FindBy(css = SWITCH_BUTTON)
    private WebElement switchButton;

    @FindBy(css = ARCHIVED_LIST)
    private List<WebElement> archivedLists;

    public ArchivedItemsBoard(final WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        action.waitElementVisible(tittle);
        return tittle.isDisplayed();
    }

    public ArchivedItemsBoard switchItems() {
        action.waitElementVisible(switchButton);
        if (switchButton.getText().contains("list")) {
            action.click(switchButton);
        }
        return this;
    }

    public List<String> archivedItemsList() {
        action.waitForVisibilityOfAllElements(archivedLists);
        return archivedLists.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
