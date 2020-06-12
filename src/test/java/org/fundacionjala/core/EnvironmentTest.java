package org.fundacionjala.core;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EnvironmentTest {

    public static final int EXPECTED_EXPLICIT = 20;
    public static final int EXPECTED_REDUCED = 2;
    public static final int EXPECTED_IMPLICIT = 15;
    private static Environment env;

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void givenAnEnvironmentWhenGettingEnvironmentNameThenNotNull() {
        env = Environment.getInstance();

        String envName = env.getEnvironmentName();

        assertNotNull(envName);
    }

    @Test
    public void testGetUiBaseUrl() {
        env = Environment.getInstance();

        String envUiBaseUrl = env.getUiBaseUrl();

        assertNotNull(envUiBaseUrl);
    }

    @Test
    public void testGetApiBaseUri() {
        env = Environment.getInstance();

        String envApiBaseUri = env.getApiBaseUri();

        assertNotNull(envApiBaseUri);
    }

    @Test
    public void testGetImplicitTimeWait() {
        env = Environment.getInstance();

        int envImplicitTimeWait = env.getImplicitTimeWait();

        assertEquals(envImplicitTimeWait, EXPECTED_IMPLICIT);
    }

    @Test
    public void testGetExplicitTimeWait() {
        env = Environment.getInstance();

        int envExplicitTimeWait = env.getExplicitTimeWait();

        assertEquals(envExplicitTimeWait, EXPECTED_EXPLICIT);
    }

    @Test
    public void testGetReducedTime() {
        env = Environment.getInstance();

        int envReducedTime = env.getReducedTime();

        assertEquals(envReducedTime, EXPECTED_REDUCED);
    }

    @Test
    public void testGetBrowserName() {
        env = Environment.getInstance();

        String envBrowserName = env.getBrowserName();

        assertEquals(envBrowserName, "chrome");
    }

    @Test
    public void testGetThreadCount() {
        env = Environment.getInstance();

        String envThreadCount = env.getThreadCount();

        assertNotNull(envThreadCount);
    }

    @Test
    public void testGetRemoteServerEnvironment() {
        env = Environment.getInstance();

        String envRemoteServerUrl = env.getRemoteServerEnvironment();

        assertNotNull(envRemoteServerUrl);
    }
}
