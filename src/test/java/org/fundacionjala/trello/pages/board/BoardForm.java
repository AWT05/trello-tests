package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.pages.forms.FormFieldsEnum;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.core.ui.pages.forms.IFillerField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.TITLE;

public final class BoardForm extends FormPage<BoardPage> {

    private static final String BOARD_TITLE_INPUT = "input[data-test-id=\"create-board-title-input\"]";
    private static final String CREATE_BOARD_BUTTON = "button[data-test-id=\"create-board-submit-button\"]";

    @FindBy(css = BOARD_TITLE_INPUT)
    private WebElement inputTitle;

    @FindBy(css = CREATE_BOARD_BUTTON)
    private WebElement createButton;

    public BoardForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return createButton.isDisplayed();
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(TITLE, this::setTitle);
        return data;
    }

    public BoardForm setTitle(final String title) {
        inputTitle.sendKeys(title);
        return this;
    }

    @Override
    public BoardPage submit() {
        action.click(createButton);
        return new BoardPage(driver);
    }
}
