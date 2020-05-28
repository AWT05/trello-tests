package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.forms.FormFieldsEnum;
import static org.fundacionjala.trello.pages.forms.FormFieldsEnum.NAME;
import static org.fundacionjala.trello.pages.forms.FormFieldsEnum.TYPE;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.forms.IFillerField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TeamForm extends FormPage<TeamPage> {

    private static final String TEAM_NAME_INPUT = "input[data-test-id=\"header-create-team-name-input\"]";
    private static final String TEAM_TYPE_DISPLAY = "#teamTypeSelect > div > div";
    private static final String TEAM_TYPE_LIST = "div[data-test-id*=\"header-create-team-type-input-\"]";
    private static final String CREATE_TEAM_BUTTON = "button[data-test-id=\"header-create-team-submit-button\"]";

    @FindBy(css = TEAM_NAME_INPUT)
    private WebElement inputName;

    @FindBy(css = CREATE_TEAM_BUTTON)
    private WebElement createButton;

    @FindBy(css = TEAM_TYPE_DISPLAY)
    private WebElement teamTypeDisplay;

    @FindBy(css = TEAM_TYPE_LIST)
    private List<WebElement> teamTypeList;

    public TeamForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return createButton.isDisplayed();
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(NAME, this::setName);
        data.put(TYPE, this::setType);
        return data;
    }

    public TeamForm setName(final String name) {
        inputName.sendKeys(name);
        return this;
    }

    public TeamForm setType(final String type) {
        teamTypeDisplay.click();
        for (WebElement typeElement : teamTypeList) {
            if (typeElement.getAttribute("data-test-id").contains(type.toLowerCase())) {
                typeElement.click();
                break;
            }
        }
        return this;
    }

    @Override
    public TeamPage submit() {
        click(createButton);
        return new TeamPage(driver);
    }
}
