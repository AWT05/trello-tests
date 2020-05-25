package org.fundacionjala.trello.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {
    private static final int WIDTH = 414;
    private static final int HEIGHT = 736;
    private static WebDriver driver;

    private DriverFactory() {
        // prevent instantiations
    }

    /**
     * @return the chrome web driver.
     */
    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Resizes the window to 414 x 736 px.
     */
    public static void lightScreen() {
        getChromeDriver();
        driver.manage().window().setSize(new Dimension(WIDTH, HEIGHT));
    }
}
