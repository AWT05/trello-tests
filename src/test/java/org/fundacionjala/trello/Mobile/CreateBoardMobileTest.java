package org.fundacionjala.trello.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class CreateBoardMobileTest {
    protected static WebDriver driver;
    private final static String ADD_BUTTON = "com.trello:id/add_fab";
    private final static String ADD_BOARD_BUTTON = "com.trello:id/add_board_fab";
    private final static String BOARD_NAME = "com.trello:id/board_name";
    private final static String TEAM_DROPDOWN = "com.trello:id/team_spinner";
    private final static String LIST_OF_TEAMS_XPATH = "//android.widget.ListView/android.view.ViewGroup";
    private final static String CREATE_BUTTON = "com.trello:id/create_board";
    private final static String BOARD_TITLE = "com.trello:id/toolbar_title";


    @FindBy(id = ADD_BUTTON)
    private MobileElement addButton;

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

    @BeforeMethod
    public static void setUp() {
        DesiredCapabilities desCap = new DesiredCapabilities();
        desCap.setCapability("deviceName", "Mau-android");
        desCap.setCapability("platformName", "Android");
        desCap.setCapability("platformVersion", "1.7.2");
        desCap.setCapability("appPackage ", "com.trello");
        desCap.setCapability("appActivity  ", ".home.HomeActivity");
        WebDriver driver1 = new AppiumDriver(desCap);
        driver1.get("http://localhost:5554/wd/hub");
        driver = driver1;
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
        addButton.click();
        addCardButton.click();
        boardName.sendKeys("FirstMobileBoard");
        teamDropdown.click();
        listOfteams.get(0).click();
        createButton.click();
        assertEquals(boardTitle.getText(), "FirstMobileBoard");
    }
}
