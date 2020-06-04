package org.fundacionjala.core.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {

    }

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    /**
     * @return the chrome web driver.
     */
    public static WebDriver getChromeDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    /**
     * Resize the browser window.
     *
     * @param width Width of the browser window in px.
     * @param height Height of the browser window in px.
     */
    public static void resizeScreen(final int width, final int height) {
        driver = getChromeDriver();
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
