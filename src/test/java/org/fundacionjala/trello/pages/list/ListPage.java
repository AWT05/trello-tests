package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.card.CardForm;
import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public final class ListPage extends PageObject {

    private static final String NAME_LISTS_TEXT_AREA = "textarea.list-header-name";
    public static final String LIST_LOCATOR = "//textarea[contains(text(), '%s')]/parent::div/parent::div/"
            + "div[contains(@class, 'card-composer-container')]//span[@class= 'icon-sm icon-add']";

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

    private WebElement searchList(final String listName) {
        return driver.findElement(By.xpath(String.format(LIST_LOCATOR, listName)));
    }

    public FormPage<?> createNewCard(final String listname) {
        action.click(searchList(listname));
        return new CardForm(driver);
    }
}
