package org.fundacionjala.trello.pages.card;

import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public final class CardPage extends PageObject {
    private static final String GETS_ALL_CARDS_IN_A_LIST = "//textarea[contains(text(), '%s')]/parent::div/"
            + "parent::div//span[@class='list-card-title js-card-name']";
    private static final String ADD_NEW_CARD_BUTTON = "span.js-add-a-card";
    private static final String ALL_CARDS_LIST = "a.list-card";
    private static final String CARD_TITLE = "//*[@id=\"chrome-container\"]/div[3]/div/div/div/div[3]/div[1]/h2";
    private static final String CARD_DESCRIPTION = "//p/parent::div/div[@class='current markeddown hide-on-edit js-desc js-show-with-desc']";
    private static final String CARD_TITLE_TEXT_AREA = "mod-card-back-title js-card-detail-title-input";

    @FindBy(css = ADD_NEW_CARD_BUTTON)
    private WebElement addNewCardButton;

    @FindBy(css = ALL_CARDS_LIST)
    private List<WebElement> cardsList;

    @FindBy(xpath = CARD_TITLE)
    private WebElement cardTitle;

    @FindBy(css = CARD_TITLE_TEXT_AREA)
    private WebElement cardTitleTextArea;

    @FindBy(xpath = CARD_DESCRIPTION)
    private WebElement cardDescription;

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

    public FormPage<?> navigateToCard(final String listName, final String cardName) {
        List<WebElement> getCards = getCardElementsInList(listName);
        for (WebElement getCard : getCards) {
            if (getCard.getText().equals(cardName)) {
                getCard.click();
                return new CardUpdateForm(driver);
            }
        }
        return null;
    }

    public String getCardTitle() {
        String locator = String.format("//h2[contains(text(), '%s')]", "Task 1");
        WebElement test = driver.findElement(By.xpath(locator));
        return test.getText();
    }

    public String getCardDescription() {
        return cardDescription.getText();
    }
}
