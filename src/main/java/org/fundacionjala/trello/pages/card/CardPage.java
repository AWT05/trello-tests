package org.fundacionjala.trello.pages.card;

import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class CardPage extends PageObject {
    private static final String CARD_NAMES_LIST = "div.list-cards";

    @FindBy(css = CARD_NAMES_LIST)
    private List<WebElement> cardNames;

    public CardPage(WebDriver driver) {
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

    public List<String> getAllCardNames() {
        return cardNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

