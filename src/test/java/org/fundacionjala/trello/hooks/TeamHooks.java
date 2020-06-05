package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.fundacionjala.trello.pages.team.TeamSettings;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public class TeamHooks {

    private static final int CLEAN_CONTEXT_ORDER_TEAM_UI = 10;

    /**
     * Delete a Team if it was created by UI.
     */
    @After(value = "@deleteTeamUi", order = CLEAN_CONTEXT_ORDER_TEAM_UI)
    public void deleteTeamByUi() {
        TeamPage team = new TeamPage(getDriver());
        TeamSettings teamSettings = team.goToSettings();
        if (!teamSettings.isDisplayed()) {
            return;
        }
        teamSettings.deleteTeam();
    }
}
