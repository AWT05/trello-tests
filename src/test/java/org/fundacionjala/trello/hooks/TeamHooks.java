package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.fundacionjala.trello.pages.team.TeamSettings;

import static org.fundacionjala.trello.context.EndPointsEnum.TEAM;
import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public class TeamHooks {

    private static final int CLEAN_CONTEXT_ORDER_TEAM_UI = 10;
    private static final int CLEAN_CONTEXT_ORDER_TEAM = 11;
    private final ContextTrello context;
    private final RequestManager requestManager;

    public TeamHooks(final ContextTrello context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

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

    /**
     * Delete a team if it was created by API.
     */
    @After(value = "@deleteTeam", order = CLEAN_CONTEXT_ORDER_TEAM)
    public void deleteTeamByApi() {
        context.getUsers().forEach(user -> {
            requestManager.setApiCredentials(user.getKeyword());
            user.getIdsByKey(TEAM).forEach(id -> requestManager
                    .init(context)
                    .delete(TEAM.getEndPoint().concat(id)));
        });
    }
}
