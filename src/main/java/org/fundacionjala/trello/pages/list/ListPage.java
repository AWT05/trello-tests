package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends PageObject {

    private static final String ADD_LIST = "div.js-add-list span.icon-add";

    @FindBy(css = ADD_LIST)
    WebElement addListIcon;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        return false;
    }

    /*public ListPage AddNewList(String name) {
        action.setInputField(addListIcon, name);
        return new ListPage(driver);
    }*/
}
