package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.team.TeamInviteForm;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.fundacionjala.trello.pages.team.TeamProfileForm;
import org.fundacionjala.trello.pages.team.TeamSettings;
import org.fundacionjala.trello.utils.AssertGroup;
import org.testng.asserts.Assertion;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class TeamStepDefs {

    private static final String NAME_KEY = "name";
    private static final String DESCRIPTION_KEY = "description";
    private TeamPage teamPage;
    private TeamInviteForm teamInviteForm;
    private TeamSettings teamSettings;
    private TeamProfileForm teamProfileForm;
    private Assertion assertGroup;

    public TeamStepDefs(final SharedDriver sharedDriver, final AssertGroup assertGroup) {
        this.teamPage = new TeamPage(getDriver());
        this.teamInviteForm = new TeamInviteForm(getDriver());
        this.teamSettings = new TeamSettings(getDriver());
        this.teamProfileForm = new TeamProfileForm(getDriver());
        this.assertGroup = assertGroup.getAssertGroup();
    }

    /**
     * Validates the creation of the team with the given data.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a team created with the following data")
    public void validateCreationWithData(final Map<String, String> expectedData) {
        assertGroup.assertEquals(teamPage.getTeamName(), expectedData.get(NAME_KEY));
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
     * Opens the section selected on a team page.
     */
    @When("I open settings")
    public void iOpenSettings() {
        teamSettings = teamPage.goToSettings();
    }

    /**
     * Deletes actual team.
     */
    @When("I delete the team")
    public void iDeleteTheTeam() {
        teamSettings.deleteTeam();
    }

    /**
     * Open team profile edition form.
     */
    @When("I open edit team profile")
    public void iOpenEditTeamProfile() {
        teamProfileForm = teamPage.editTeamProfile();
    }

    /**
     * Update a team with the given information.
     *
     * @param newData Edition values.
     */
    @When("I update the team's information with the following data")
    public void iUpdateTheTeamSInformationWith(final Map<String, String> newData) {
        teamProfileForm.fillForm(newData);
        teamProfileForm.submit();
    }

    /**
     * Verify a given value has been updated.
     *
     * @param shortName Value of shortname given.
     */
    @Then("I should have the team with shortname {string}")
    public void iShouldHaveTheTeamWithShortname(final String shortName) {
        assertGroup.assertTrue(getDriver().getCurrentUrl().contains(shortName));
    }

    @Then("I should have the team updated with the following data")
    public void iShouldHaveTheTeamUpdatedWithTheFollowingData(final Map<String, String> expectedData) {
        assertGroup.assertEquals(teamPage.getTeamName(), expectedData.get(NAME_KEY));
        assertGroup.assertEquals(teamPage.getTeamDescription(), expectedData.get(DESCRIPTION_KEY));
    }
}
