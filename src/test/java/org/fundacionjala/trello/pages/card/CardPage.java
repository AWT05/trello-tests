package org.fundacionjala.trello.pages.card;

import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public final class CardPage extends PageObject {
    private static final String GETS_ALL_CARDS_IN_A_LIST = "//textarea[contains(text(), '%s')]/parent::div/"
            + "parent::div//span[@class='list-card-title js-card-name']";
    private static final String ADD_NEW_CARD_BUTTON = "span.js-add-a-card";
    private static final String ALL_CARDS_LIST = "a.list-card";
    private static final String CARD_TITLE = "card-detail-title-assist js-title-helper";



    @FindBy(css = ADD_NEW_CARD_BUTTON)
    private WebElement addNewCardButton;

    @FindBy(css = ALL_CARDS_LIST)
    private List<WebElement> cardsList;

    @FindBy(css = CARD_TITLE)
    private WebElement cardTitle;

    public CardPage(final WebDriver driver) {
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

    public List<String> getCardNamesInList(final String listName) {
        List<WebElement> getCards = getCardElementsInList(listName);
        List<String> list = new ArrayList<>();
        for (WebElement getCard : getCards) {
            String text = getCard.getText();
            list.add(text);
        }
        return list;
    }

    public List<WebElement> getCardElementsInList(final String listName) {
        String cardsInListLocator = String.format(GETS_ALL_CARDS_IN_A_LIST, listName);
        action.waitForVisibilityOfAllElements(cardsList);
        List<WebElement> getCards = driver.findElements(By.xpath(cardsInListLocator));
        return getCards;
    }

    public void navigateToCard(final String listName, final String cardName) {
        List<WebElement> getCards = getCardElementsInList(listName);
        for (WebElement getCard : getCards) {
            if(getCard.getText().equals(cardName)){
                getCard.click();
            }
        }
    }

    public String getCardTitle() {
        wait.until(ExpectedConditions.visibilityOf(cardTitle));
        return cardTitle.getText();
    }
}
