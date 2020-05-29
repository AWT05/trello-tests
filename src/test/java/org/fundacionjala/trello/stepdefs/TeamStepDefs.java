package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import org.fundacionjala.trello.pages.team.TeamInviteForm;
import org.fundacionjala.trello.pages.team.TeamPage;
import static org.testng.Assert.assertEquals;

import java.util.Map;

public final class TeamStepDefs {
    private TeamPage teamPage;
    private final Context context;

    public TeamStepDefs(final Context context) {
        this.context = context;
    }

    /**
     * Validates the creation of the team with the given data.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a team created with the following data")
    public void validateCreationWithData(final Map<String, String> expectedData) {
        teamPage = new TeamPage(getChromeDriver());
        assertEquals(teamPage.getTeamName(), expectedData.get("name"));
    }

    /**
     * Skips the step of inviting members.
     */
    @When("I skip inviting members")
    public void iSkipInvitingMembers() {
        TeamInviteForm teamInviteForm = new TeamInviteForm(getChromeDriver());
        teamInviteForm.skipInvite();
    }
}
