package org.fundacionjala.trello.pages.board;

<<<<<<< HEAD:src/test/java/org/fundacionjala/trello/pages/board/BoardForm.java
import org.fundacionjala.core.ui.pages.forms.FormFieldsEnum;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.core.ui.pages.forms.IFillerField;
=======
import org.fundacionjala.trello.pages.forms.FormFieldsEnum;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.forms.IFillerField;
import org.openqa.selenium.By;
>>>>>>> ad5e39184211e3bc0bc901a3a4b31a5293a96f19:src/main/java/org/fundacionjala/trello/pages/board/BoardForm.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD:src/test/java/org/fundacionjala/trello/pages/board/BoardForm.java
import static org.fundacionjala.core.ui.pages.forms.FormFieldsEnum.TITLE;
=======
import static org.fundacionjala.trello.pages.forms.FormFieldsEnum.TEAM;
import static org.fundacionjala.trello.pages.forms.FormFieldsEnum.TITLE;
>>>>>>> ad5e39184211e3bc0bc901a3a4b31a5293a96f19:src/main/java/org/fundacionjala/trello/pages/board/BoardForm.java

public final class BoardForm extends FormPage<BoardPage> {

    private static final String TITLE_INPUT = "input[data-test-id=\"create-board-title-input\"]";
    private static final String TEAM_DROPDOWN = "input[data-test-id=\"create-board-title-input\"] + button";
    private static final String CREATE_BOARD_BUTTON = "button[data-test-id=\"create-board-submit-button\"]";
    private static final String XPATH_TEAM_OPTION =
            "//div[@class='atlaskit-portal']//span[text()='%s']//parent::button";

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

    public BoardForm setTitle(final String title) {
        inputTitle.sendKeys(title);
        return this;
    }

    public BoardForm setTeam(final String team) {
        action.click(dropdownTeam);
        String locator = String.format(XPATH_TEAM_OPTION, team);
        WebElement teamSelected = driver.findElement(By.xpath(locator));
        action.click(teamSelected);
        wait.until(ExpectedConditions.invisibilityOf(teamSelected));
        return this;
    }

    @Override
    public BoardPage submit() {
        action.click(createButton);
        return new BoardPage(driver);
    }
}
