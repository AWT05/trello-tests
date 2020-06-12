package org.fundacionjala.core;

import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

import java.util.Map;

public class RemoteServerEnvTest {

    private RemoteServerEnv env;

    @Test
    public void testGetRemoteServerURL() {
        env = RemoteServerEnv.getInstance();

        String url = env.getRemoteServerURL();

        assertNotNull(url);
    }

    @Test
    public void testGetCapabilities() {
        env = RemoteServerEnv.getInstance();

        Map<String, String> capabilities = env.getCapabilities();

        assertNotNull(capabilities);
    }

    @Test
    public void testGetRemoteEnvironments() {
        env = RemoteServerEnv.getInstance();

        Map<String, String> environments = env.getRemoteEnvironments();

        assertNotNull(environments);
    }
}
