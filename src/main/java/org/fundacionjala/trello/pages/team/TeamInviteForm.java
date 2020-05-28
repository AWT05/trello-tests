package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.forms.FormFieldsEnum;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.forms.IFillerField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class TeamInviteForm extends FormPage<TeamPage> {


    private static final String INVITE_LATER_BUTTON = "a[data-test-id=\"show-later-button\"]";
    private static final String EMAIL_TEAM_MEMBERS_INPUT = "input[class=\"autocomplete-input\"]";
    private static final String INVITE_TO_TEAM = "button[class='autocomplete-btn primary disabled fullWidthButton']";

    @FindBy(css = INVITE_LATER_BUTTON)
    private WebElement inviteLaterButton;

    @FindBy(css = INVITE_TO_TEAM)
    private WebElement inviteTeam;

    @FindBy(css = EMAIL_TEAM_MEMBERS_INPUT)
    private WebElement emailInput;

    public TeamInviteForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        return null;
    }

    public TeamInviteForm skipInvite() {
        inviteLaterButton.click();
        return this;
    }

    @Override
    public TeamPage submit() {
        click(inviteTeam);
        return new TeamPage(driver);
    }

    @Override
    public boolean isDisplayed() {
        return inviteTeam.isDisplayed();
    }
}
