package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;

import static org.fundacionjala.trello.context.EndPointsEnum.TEAM;

public class TeamHooks {

    private static final int CLEAN_CONTEXT_ORDER_VALUE_TEAM = 10;
    private final Context context;
    private final RequestManager requestManager;

    public TeamHooks(final Context context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Delete a team if it was created.
     */
    @After(value = "@deleteTeam", order = CLEAN_CONTEXT_ORDER_VALUE_TEAM)
    public void deleteTeam() {
        deleteByApi();
    }

    private void deleteByApi() {
        context.getIdsByKey(TEAM)
                .forEach(id -> requestManager.init(context).delete(TEAM.getEndPoint().concat(id)));
    }
}
