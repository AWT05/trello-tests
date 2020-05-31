package org.fundacionjala.trello.pages.list;

import org.fundacionjala.trello.pages.forms.FormFieldsEnum;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.forms.IFillerField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.pages.forms.FormFieldsEnum.NAME;
import static org.openqa.selenium.Keys.ENTER;

public final class ListUpdateForm extends FormPage<ListPage> {

    private static final String UPDATE_LIST_NAME = "textarea.js-list-name-input";

    @FindBy(css = UPDATE_LIST_NAME)
    private WebElement lisNameInput;

    public ListUpdateForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(NAME, this::setName);
        return data;
    }

    public ListUpdateForm setName(final String newListName) {
        lisNameInput.clear();
        action.setInputField(lisNameInput, newListName);
        return this;
    }

    @Override
    public ListPage submit() {
        lisNameInput.sendKeys(ENTER);
        driver.navigate().refresh();
        return new ListPage(driver);
    }
}
