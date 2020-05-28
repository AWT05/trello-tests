package org.fundacionjala.trello.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fundacionjala.trello.config.Environment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ManageDriver {
    private static final String BASE_URL = Environment.getInstance().getUiBaseUrl();
    private static final Integer IMPLICIT_TIME_WAIT = Environment.getInstance().getImplicitTimeWait();
    private static final Integer EXPLICIT_TIME_WAIT = Environment.getInstance().getExplicitTimeWait();
    private final WebDriver driver;
    private WebDriverWait wait;
    private static ManageDriver instance;


    private ManageDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static ManageDriver getInstance() {
        if (instance == null) {
            instance = new ManageDriver();
        }
        return instance;
    }

    public void getBaseUrl() {
        driver.get(BASE_URL);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        wait = new WebDriverWait(driver, EXPLICIT_TIME_WAIT);
        return wait;
    }

    public void getImplicitWait() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME_WAIT, TimeUnit.SECONDS);
    }

    public void mobileScreen() {
        driver.manage().window().setSize(new Dimension(414, 736));
    }

    public void fullScreen() {
        driver.manage().window().maximize();
    }
}
