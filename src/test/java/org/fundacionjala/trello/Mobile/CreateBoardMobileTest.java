package org.fundacionjala.trello.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CreateBoardMobileTest {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    private final static String ADD_BUTTON = "com.trello:id/add_fab";
    private final static String ADD_BOARD_BUTTON = "com.trello:id/add_board_fab";
    private final static String BOARD_NAME = "com.trello:id/board_name";
    private final static String TEAM_DROPDOWN = "com.trello:id/team_spinner";
    private final static String LIST_OF_TEAMS_XPATH = "//android.widget.ListView/android.view.ViewGroup";
    private final static String CREATE_BUTTON = "com.trello:id/create_board";
    private final static String BOARD_TITLE = "com.trello:id/toolbar_title";
    private final static String PRIMARY_CREDENTIAL = "com.google.android.gms:id/credential_primary_label";
    private final static String LIST_OF_HOME_XPATH = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout";

    private final static String ADD_BUTTON_XPATH = "//android.widget.ImageButton[@content-desc='Open Create Board or Add Card menu']";
    @FindBy(xpath = ADD_BUTTON_XPATH)
    private MobileElement addButtonXpath;

    @FindBy(id = ADD_BUTTON)
    private WebElement addButton;

    @FindBy(id = ADD_BOARD_BUTTON)
    private MobileElement addCardButton;

    @FindBy(id = BOARD_NAME)
    private MobileElement boardName;

    @FindBy(id = TEAM_DROPDOWN)
    private MobileElement teamDropdown;

    @FindBy(xpath = LIST_OF_TEAMS_XPATH)
    private List<MobileElement> listOfteams;

    @FindBy(id = CREATE_BUTTON)
    private MobileElement createButton;

    @FindBy(id = BOARD_TITLE)
    private MobileElement boardTitle;

    @FindBy(id = PRIMARY_CREDENTIAL)
    private MobileElement primarySmartlockCredential;

    @FindBy(xpath = LIST_OF_HOME_XPATH)
    private List<MobileElement> listOfAllElements;

    @BeforeMethod
    public static void setUp() {

        DesiredCapabilities desCap = new DesiredCapabilities();
        desCap.setCapability("deviceName", "Mau-android");
        desCap.setCapability("platformName", "Android");
        desCap.setCapability("platformVersion", "7.1.2");
        desCap.setCapability("appPackage", "com.trello");
        desCap.setCapability("appActivity", ".home.HomeActivity");
        desCap.setCapability("udid", "emulator-5554");
        try {
            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:5554/wd/hub"), desCap);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            WebDriver driver1 = new AppiumDriver(desCap);
//            driver1.get("http://127.0.0.1:localhost:5554/wd/hub/");
//            driver = driver1;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


//        AndroidDriver driver2=new AndroidDriver(desCap);
        System.out.println("Executed BEFORE method");
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
        System.out.println("Executed AFTER method");
    }

    @Test
    public void createBoardMobileTest() {
        wait = new WebDriverWait(driver, 15);
        //login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.trello:id/view_pager")));
//        primarySmartlockCredential.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout")));
        addButton.click();
//        driver.findElement(By.id("com.trello:id/add_fab")).click();
        addButtonXpath.click();
        addCardButton.click();
        boardName.sendKeys("FirstMobileBoard");
        teamDropdown.click();
        listOfteams.get(0).click();
        createButton.click();
        assertEquals(boardTitle.getText(), "FirstMobileBoard");
    }
}
