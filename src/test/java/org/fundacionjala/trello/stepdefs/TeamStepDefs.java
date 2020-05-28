package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import org.fundacionjala.trello.context.Context;
import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import org.fundacionjala.trello.pages.team.TeamInviteForm;
import org.fundacionjala.trello.pages.team.TeamPage;
import static org.testng.Assert.assertTrue;

import java.util.Map;

public class TeamStepDefs {
    private TeamPage teamPage;
    private final Context context;

    public TeamStepDefs(final Context context) {
        this.context = context;
    }

    /**
     * Validates the creation of the team with the given data.
     *
     * @param actualData expected data to validate the creation.
     */
    @Then("I should have a team created with the following data")
    public void validateCreationWithData(final Map<String, String> actualData) {
        teamPage = new TeamPage(getChromeDriver());
        assertTrue(teamPage.getUrl().contains(actualData.get("url")));
    }

    @Then("I skip inviting members")
    public void iSkipInvitingMembers() {
        TeamInviteForm teamInviteForm = new TeamInviteForm(getChromeDriver());
        teamInviteForm.skipInvite();
    }
}
