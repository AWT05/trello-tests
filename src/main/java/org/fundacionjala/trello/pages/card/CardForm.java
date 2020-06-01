package org.fundacionjala.trello.pages.card;

import org.fundacionjala.trello.pages.forms.FormFieldsEnum;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.forms.IFillerField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.pages.forms.FormFieldsEnum.NAME;

public class CardForm extends FormPage<CardPage> {

    private static final String NEW_CARD_NAME = "textarea.list-card-composer-textarea";
    private static final String ADD_CARD_SUBMIT_BUTTON = "input.js-add-card";

    @FindBy(css = NEW_CARD_NAME)
    private WebElement cardNameInput;

    @FindBy(css = ADD_CARD_SUBMIT_BUTTON)
    private WebElement addCardSubmitButton;

    public CardForm(WebDriver driver) {
        super(driver);
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(NAME, this::setName);
        return data;
    }

    public CardForm setName(final String cardName) {
        action.setInputField(cardNameInput, cardName);
        return this;
    }

    @Override
    public CardPage submit() {
        action.click(addCardSubmitButton);
        return new CardPage(driver);
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }
}
