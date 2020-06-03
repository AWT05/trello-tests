package org.fundacionjala.trello.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private static List<WebDriver> storedDrivers = new ArrayList<>();
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
    }

    private DriverFactory() {
    }

    public static void setDriver(WebDriver driver) {
        drivers.set(driver);
        storedDrivers.add(driver);
    }

    /**
     * @return the chrome web driver.
     */
    public static WebDriver getDriver() {
        return drivers.get();
    }
}
