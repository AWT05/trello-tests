package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListPage extends PageObject {

    private static final String NAME_LISTS = "h2.list-header-name-assist";

    @FindBy(css = NAME_LISTS)
    private List<WebElement> listNames;

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
        return true;
    }

    public List<String> getAllListsNames() {
        List<String> names = new ArrayList<>();
        for (WebElement element: listNames){
            names.add(getElementText(element));
        }
        return names;
        //return listNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}

