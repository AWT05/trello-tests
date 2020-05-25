package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fundacionjala.trello.driver.DriverFactory;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public final class CommonHooks {

    private static final int CLEAN_CONTEXT_ORDER_VALUE = 10;
    private static final int INIT_CONTEXT_ORDER_VALUE = 0;

    @Before(order = INIT_CONTEXT_ORDER_VALUE)
    public void openAndResizeWindow() {
        DriverFactory.lightScreen();
    }

    @After(order = CLEAN_CONTEXT_ORDER_VALUE)
    public void quitDriver() {
        getChromeDriver().quit();
    }
}
