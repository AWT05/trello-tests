package org.fundacionjala.trello.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private static final Map<String, Supplier<AbstractBrowser>> BROWSER = new HashMap<>();

    static {
        BROWSER.put("chrome", Chrome::new);
        BROWSER.put("headless", Headless::new);
    }

    public static WebDriver getBrowser(String browser) {
        // Does not support the browser
        // code here
        return BROWSER.getOrDefault(browser, Chrome::new).get().initBrowser();
    }
}