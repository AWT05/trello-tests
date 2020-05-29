package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;

import static org.fundacionjala.trello.context.EndPointsEnum.TEAM;

public class TeamHooks {

    private static final int CLEAN_CONTEXT_ORDER_TEAM_API = 11;
    private final Context context;
    private final RequestManager requestManager;

    public TeamHooks(final Context context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Delete a team if it was created.
     */
    @After(value = "@deleteTeamApi", order = CLEAN_CONTEXT_ORDER_TEAM_API)
    public void deleteTeamByApi() {
        context.getIdsByKey(TEAM)
                .forEach(id -> requestManager.init(context).delete(TEAM.getEndPoint().concat(id)));
    }
}
