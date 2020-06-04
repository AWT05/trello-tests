package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.team.TeamInviteForm;
import org.fundacionjala.trello.pages.team.TeamPage;

import java.util.Map;

import static org.fundacionjala.core.ui.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertEquals;

public final class TeamStepDefs {

    private TeamPage teamPage;
    private TeamInviteForm teamInviteForm;

    public TeamStepDefs() {
        this.teamPage = new TeamPage(getChromeDriver());
        this.teamInviteForm = new TeamInviteForm(getChromeDriver());
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
}
