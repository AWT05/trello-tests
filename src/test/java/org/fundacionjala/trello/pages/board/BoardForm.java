package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.pages.forms.FormFieldsEnum;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.core.ui.pages.forms.IFillerField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.TEAM;
import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.TITLE;

public final class BoardForm extends FormPage<BoardPage> {

    private static final String TITLE_INPUT = "input[data-test-id=\"create-board-title-input\"]";
    private static final String TEAM_DROPDOWN = "input[data-test-id=\"create-board-title-input\"] + button";
    private static final String CREATE_BOARD_BUTTON = "button[data-test-id=\"create-board-submit-button\"]";
    private static final String TEAM_OPTIONS_BUTTON = "input[data-test-id=\"create-board-title-input\"] + button";
    private static final String XPATH_NO_TEAM_OPTION =
            "(//div[@class='atlaskit-portal']//span[text()]//parent::button)[1]";
    private static final String XPATH_TEAM_OPTION =
            "//div[@class='atlaskit-portal']//span[text()='%s']//parent::button";
    private static final String NO_TEAM = "No Team";

    @FindBy(css = TITLE_INPUT)
    private WebElement inputTitle;

    @FindBy(css = TEAM_DROPDOWN)
    private WebElement dropdownTeam;
/*

    @FindBy(css = "input[data-test-id=\"create-board-title-input\"] + button > span")
    private WebElement contentDropdownTeam;
*/

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
        data.put(TEAM, this::setTeam);
        return data;
    }

    @Override
    public BoardPage submit() {
        action.click(createButton);
        return new BoardPage(driver);
    }

    public BoardForm setTitle(final String title) {
        inputTitle.sendKeys(title);
        return this;
    }

    public BoardForm setTeam(final String team) {
        action.click(dropdownTeam);
        selectTeamOption(team);
        return this;
    }

    private void selectTeamOption(final String team) {
        String locator;
        if (NO_TEAM.equals(team)) {
            locator = XPATH_NO_TEAM_OPTION;
        } else {
            locator = String.format(XPATH_TEAM_OPTION, team);
        }
        action.click(driver.findElement(By.xpath(locator)));
    }
}
