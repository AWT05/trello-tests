package org.fundacionjala.trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.core.Environment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        strict = true,
        plugin = {"pretty"},
        glue = {"org.fundacionjala.trello"},
        features = {"src/test/resources/features"}
)
public final class Runner extends AbstractTestNGCucumberTests {

    /**
     * Executes code before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() {
        // Code executed before features execution.
        System.setProperty("dataproviderthreadcount", Environment.getInstance().getThreadCount());
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Executes code after all scenarios.
     */
    @AfterTest
    public void afterAllScenarios() {
        // Code executed after features execution.
    }
}
