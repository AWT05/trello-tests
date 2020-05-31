package org.fundacionjala.trello.pages.card;

import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.list.ListForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class CardPage extends PageObject {
    private static final String CARD_NAMES_LIST = "div.list-cards";
    private static final String ADD_NEW_CARD_BUTTON = "span.js-add-a-card";

    @FindBy(css = CARD_NAMES_LIST)
    private List<WebElement> cardNames;

    @FindBy(css = ADD_NEW_CARD_BUTTON)
    private WebElement addNewCardButton;

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

    public FormPage<?> createNewCard() {
        action.click(addNewCardButton);
        return new CardForm(driver);
    }
}
