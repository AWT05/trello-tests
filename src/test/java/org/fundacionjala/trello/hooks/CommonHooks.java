package org.fundacionjala.trello.hooks;

import io.cucumber.java.Before;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.DriverFactory;

public final class CommonHooks {

    private static final int INIT_CONTEXT_ORDER_VALUE = 0;

    /**
     * Open a browser and resize the window.
     */
    @Before(order = INIT_CONTEXT_ORDER_VALUE)
    public void openAndResizeWindow() {
        Environment env = Environment.getInstance();
        DriverFactory.resizeScreen(env.getBrowserWidth(), env.getBrowserHeight());
    }
}
