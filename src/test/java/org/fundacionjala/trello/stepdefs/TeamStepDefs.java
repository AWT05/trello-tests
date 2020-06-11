package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.fundacionjala.core.context.Context;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.team.TeamInviteForm;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.fundacionjala.trello.pages.team.TeamSettings;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public final class TeamStepDefs {

    private Context context;
    private TeamPage teamPage;
    private TeamInviteForm teamInviteForm;
    private TeamSettings teamSettings;

    public TeamStepDefs(final SharedDriver sharedDriver, final Context context) {
        this.context = context;
        this.teamPage = new TeamPage(getDriver());
        this.teamInviteForm = new TeamInviteForm(getDriver());
        this.teamSettings = new TeamSettings(getDriver());
    }

    /**
     * Validates the creation of the team with the given data.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a team created with the following data")
    public void validateCreationWithData(final Map<String, String> expectedData) {
        assertEquals(teamPage.getTeamName(), expectedData.get("name"));
    }

    /**
     * Skips the step of inviting members.
     */
    @When("I skip inviting members")
    public void iSkipInvitingMembers() {
        teamInviteForm.skipInvite();
    }

    /**
     * Opens the board selected.
     *
     * @param boardName The board name.
     */
    @When("I open the {string} board team")
    public void openTheBoardTeam(final String boardName) {
        teamPage.openBoard(boardName);
    }

    /**
     * Opens the section selected on team page.
     *
     * @param sectionName The board name.
     */
    @When("I open {string} section")
    public void iOpenSection(final String sectionName) {
        teamSettings = teamPage.goToSettings();
    }
    /**
     * Deletes actual team.
     *
     */
    @When("I delete the team")
    public void iDeleteTheTeam() {
        teamSettings.deleteTeam();
    }


}
