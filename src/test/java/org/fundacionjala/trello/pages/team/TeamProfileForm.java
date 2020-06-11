package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.pages.forms.FormFieldsEnum;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.core.ui.pages.forms.IFillerField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.DESCRIPTION;
import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.NAME;
import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.SHORTNAME;
import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.TYPE;

public class TeamProfileForm extends FormPage<TeamPage> {

    private static final String DISPLAY_NAME_INPUT = "input[id='displayName']";
    private static final String SHORT_NAME_INPUT = "input[id='name']";
    private static final String DESCRIPTION_INPUT = "textarea[id='desc']";
    private static final String SAVE_BUTTON = "button[type='submit']";
    private static final String TYPE_SELECT = "div[id='teamTypeSelect']";
    private static final String TEAM_TYPE_LIST = "//div[contains(@id,'react-select-')]/li[contains(text()," +
            "'%s')]";

    @FindBy(css = DISPLAY_NAME_INPUT)
    private WebElement teamName;

    @FindBy(css = SHORT_NAME_INPUT)
    private WebElement teamShortName;

    @FindBy(css = DESCRIPTION_INPUT)
    private WebElement teamDescription;

    @FindBy(css = SAVE_BUTTON)
    private WebElement saveButton;

    @FindBy(css = TYPE_SELECT)
    private WebElement teamTypeSelect;

    public TeamProfileForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return saveButton.isDisplayed();
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(NAME, this::setName);
        data.put(TYPE, this::setType);
        data.put(SHORTNAME, this::setShortName);
        data.put(DESCRIPTION, this::setDescription);
        return data;
    }

    private TeamProfileForm setName(final String name) {
        action.setInputField(teamName, name);
        return this;
    }

    private TeamProfileForm setType(final String type) {
        action.click(teamTypeSelect);
        WebElement typeOption = driver.findElement(By.xpath(String.format(TEAM_TYPE_LIST, type)));
        action.click(typeOption);
        return this;
    }

    private TeamProfileForm setShortName(final String shortName) {
        action.setInputField(teamShortName, shortName);
        return this;
    }

    private TeamProfileForm setDescription(final String description) {
        action.setInputField(teamDescription, description);
        return this;
    }

    @Override
    public TeamPage submit() {
        action.click(saveButton);
        return new TeamPage(driver);
    }
}
