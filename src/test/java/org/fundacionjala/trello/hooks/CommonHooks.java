package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.pages.menus.Header;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class CommonHooks {

    private static final int CLEAN_CONTEXT_ORDER = 20;
    private static final int LOGOUT_ORDER = 15;
    private final ContextTrello context;
    private final RequestManager requestManager;
    private Header header;

    public CommonHooks(final ContextTrello context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
        header = new Header(getDriver());
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

    @After(order = LOGOUT_ORDER)
    public void logoutAccount(){
        header.getMenuProfile().logOutSession();
    }
}
