package org.fundacionjala.trello.pages.card;

import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class CardPage extends PageObject {
    private static final String CARD_NAMES_LIST = "//textarea[contains(text(), '%s')]/parent::div/" +
            "parent::div//span[@class='list-card-title js-card-name']";
    private static final String ADD_NEW_CARD_BUTTON = "span.js-add-a-card";
    private static final String AUX_LIST = "a.list-card";

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

    public List<String> getAllCardNames(String listName) {
        String getCardsList = String.format(CARD_NAMES_LIST, listName);
        List<WebElement> test = driver.findElements(By.cssSelector(AUX_LIST));
        wait.until(ExpectedConditions.visibilityOfAllElements(test));
        List<WebElement> getCards = driver.findElements(By.xpath(getCardsList));
        List<String> list = new ArrayList<>();
        for (WebElement getCard : getCards) {
            String text = getCard.getText();
            list.add(text);
        }
        return list;
    }
}
