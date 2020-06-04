package org.fundacionjala.trello.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Headless extends AbstractBrowser {

    private static final String HEADLESS_MODE = "headless";

    @Override
    WebDriver initBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(HEADLESS_MODE);
        return new ChromeDriver(options);
    }
}
