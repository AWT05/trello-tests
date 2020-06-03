package org.fundacionjala.trello.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends AbstractBrowser {
    @Override
    WebDriver initBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
