package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;

import static org.fundacionjala.trello.context.EndPointsEnum.TEAM;

public class TeamHooks {

    private static final int CLEAN_CONTEXT_ORDER_TEAM = 11;
    private final ContextTrello context;
    private final RequestManager requestManager;

    public TeamHooks(final ContextTrello context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Delete a team if it was created.
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
