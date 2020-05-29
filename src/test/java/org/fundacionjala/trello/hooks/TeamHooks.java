package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.fundacionjala.trello.pages.team.TeamSettings;

public class TeamHooks {

    private static final int CLEAN_CONTEXT_ORDER_VALUE_BOARD = 15;

    /**
     * Delete a Team if it was created.
     */
    @After(value = "@deleteTeam", order = CLEAN_CONTEXT_ORDER_VALUE_BOARD)
    public void deleteTeam() {
        TeamPage team = new TeamPage(getChromeDriver());
        TeamSettings teamSettings = team.goToSettings();
        if (!teamSettings.isDisplayed()) {
            return;
        }
        teamSettings.deleteTeam();
    }
}
