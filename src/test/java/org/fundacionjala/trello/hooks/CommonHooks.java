package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.fundacionjala.trello.context.EndPointsEnum.TEAM;

public final class CommonHooks {

    private static final int CLEAN_CONTEXT_ORDER = 20;
    private final ContextTrello context;
    private final RequestManager requestManager;

    public CommonHooks(final ContextTrello context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Delete a Board if it was created by UI.
     */
    @After(value = "@cleanData", order = CLEAN_CONTEXT_ORDER)
    public void cleanTestsData() {
        deleteBoardByApi();
        deleteTeamByApi();
    }

    private void deleteBoardByApi() {
        context.getUsers().forEach(user -> {
            requestManager.setApiCredentials(user.getKeyword());
            user.getIdsByKey(BOARD).forEach(id -> requestManager
                    .init(context)
                    .delete(BOARD.getEndPoint().concat(id)));
        });
    }

    private void deleteTeamByApi() {
        context.getUsers().forEach(user -> {
            requestManager.setApiCredentials(user.getKeyword());
            user.getIdsByKey(TEAM).forEach(id -> requestManager
                    .init(context)
                    .delete(TEAM.getEndPoint().concat(id)));
        });
    }

}
