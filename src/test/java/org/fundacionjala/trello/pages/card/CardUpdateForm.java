package org.fundacionjala.trello.pages.card;

import org.fundacionjala.core.ui.pages.forms.FormFieldsEnum;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.core.ui.pages.forms.IFillerField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.DESCRIPTION;

public final class CardUpdateForm extends FormPage<CardPage> {
    private static final String UPDATE_CARD_DESC = "textarea.js-description-draft";
    private static final String UPDATE_CARD_SAVE_BUTTON = "window-module-title-icon";

    @FindBy(css = UPDATE_CARD_DESC)
    private WebElement cardDescInput;

    @FindBy(className = UPDATE_CARD_SAVE_BUTTON)
    private WebElement saveButton;

    public CardUpdateForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(DESCRIPTION, this::setDescription);
        return data;
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }

    public CardUpdateForm setDescription(final String newDescriptionName) {
        wait.until(ExpectedConditions.elementToBeClickable(cardDescInput));
        cardDescInput.clear();
        action.setInputField(cardDescInput, newDescriptionName);
        return this;
    }

    @Override
    public CardPage submit() {
        action.click(saveButton);
        return new CardPage(driver);
    }
}
