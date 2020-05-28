package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends WebPage {

    private static final String ADD_LIST = "div.js-add-list span.icon-add";

    @FindBy(css = ADD_LIST)
    WebElement addListIcon;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    /*public ListPage AddNewList(String name) {
        action.setInputField(addListIcon, name);
        return new ListPage(driver);
    }*/
}
