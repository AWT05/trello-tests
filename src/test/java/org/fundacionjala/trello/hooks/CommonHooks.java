package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.context.EndPointsEnum;

public final class CommonHooks {

    private static final int CLEAN_CONTEXT_ORDER = 20;
    private final ContextTrello context;
    private final RequestManager requestManager;

    public CommonHooks(final ContextTrello context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Deletes Items if they were created by UI or API.
     */
    @After(value = "@cleanData", order = CLEAN_CONTEXT_ORDER)
    public void cleanTestsData() {
        context.getUsers().forEach(user -> {
            requestManager.setApiCredentials(user.getKeyword());
            for (EndPointsEnum item : EndPointsEnum.values()) {
                user.getIdsByKey(item).forEach(id -> requestManager
                        .init(context)
                        .delete(item.getEndPoint().concat(id)));
            }
        });
    }
}
