package org.fundacionjala.trello.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.fundacionjala.trello.config.Environment;

public class SharedDriver {

    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            WebDriver driver = BrowserFactory.getBrowser("chrome");
            driver.manage().window().setSize(new Dimension(Environment.getInstance().getBrowserWidth(),
                    Environment.getInstance().getBrowserHeight()));
            DriverFactory.setDriver(driver);
        }
    }
}
