package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fundacionjala.trello.config.Environment;
import org.fundacionjala.trello.driver.DriverFactory;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.fundacionjala.trello.driver.DriverFactory.setDriver;

public final class CommonHooks {

    private static final int CLEAN_CONTEXT_ORDER_VALUE = 0;
    private static final int INIT_CONTEXT_ORDER_VALUE = 0;

    /**
     * Open a browser and resize the window.
     */
    @Before(order = INIT_CONTEXT_ORDER_VALUE)
    public void openAndResizeWindow() {
        setDriver();
        Environment env = Environment.getInstance();
        DriverFactory.resizeScreen(env.getBrowserWidth(), env.getBrowserHeight());
    }

    /**
     * Close browser and quit driver.
     */
    @After(order = CLEAN_CONTEXT_ORDER_VALUE)
    public void quitDriver() {
        getChromeDriver().quit();
    }
}
