package org.fundacionjala.trello.driver;

import org.fundacionjala.core.Environment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class SharedDriver {

    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            WebDriver driver = BrowserFactory.getBrowser(Environment.getInstance().getBrowserName());
            driver.manage().window().setSize(new Dimension(Environment.getInstance().getBrowserWidth(),
                    Environment.getInstance().getBrowserHeight()));
            DriverFactory.setDriver(driver);
        }
    }
}
