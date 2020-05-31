package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public final class ListPage extends PageObject {

    private static final String NAME_LISTS_TEXT_AREA = "textarea.list-header-name";

    @FindBy(css = NAME_LISTS_TEXT_AREA)
    private List<WebElement> listNames;

    public ListPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        return true;
    }

    public List<String> getAllListsNames() {
        return listNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
