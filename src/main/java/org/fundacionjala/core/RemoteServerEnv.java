package org.fundacionjala.core;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Reads remote server properties.
 */
public final class RemoteServerEnv {

    private static final String JSON_CONFIG_FILE_PATH = "remoteServerConf.json";
    private static final String USER = "user";
    private static final String KEY = "key";
    private static final String SERVER_URL = "server";
    private static final String CAPABILITIES = "capabilities";
    private static final String ENVIRONMENTS = "environments";
    private static final String SET_SERVER_CREDENTIALS = "https://%s:%s@";
    private static final String REMOTE_SERVER_ENV = Environment.getInstance().getRemoteServerEnvironment();
    private static final String ACCESS_PATH = "%s.%s";
    private static RemoteServerEnv instance;
    private final Map<String, Object> envConfig;

    /**
     * Initializes instance of remote server environment.
     */
    private RemoteServerEnv() {
        try {
            envConfig = JsonPath.with(Files.readString(Paths.get(JSON_CONFIG_FILE_PATH), StandardCharsets.UTF_8)).get();
        } catch (IOException e) {
            throw new RuntimeException("Filed to load remoteServer.conf.json");
        }
    }

    /**
     * Gets singleton instance of the RemoteServerEnv.
     *
     * @return RemoteServerEnv instance.
     */
    public static RemoteServerEnv getInstance() {
        if (instance == null) {
            instance = new RemoteServerEnv();
        }
        return instance;
    }

    /**
     * Gets remote server user name.
     *
     * @return environment name.
     */
    private String getUser() {
        return envConfig.get(USER).toString();
    }

    /**
     * Gets remote server user key.
     *
     * @return environment key.
     */
    private String getKey() {
        return envConfig.get(KEY).toString();
    }

    /**
     * Gets remote server domain.
     *
     * @return environment server domain.
     */
    private String getServerDomain() {
        return envConfig.get(SERVER_URL).toString();
    }

    /**
     * Gets remote server completely URL.
     *
     * @return environment server URL.
     */
    public String getRemoteServerURL() {
        return String.format(SET_SERVER_CREDENTIALS, getUser(), getKey()).concat(getServerDomain());
    }

    /**
     * Gets capabilities from remote server environment config.
     *
     * @return a map of general capabilities.
     */
    @SuppressWarnings("unchecked")
    public Map<String, String> getCapabilities() {
        return (Map<String, String>) envConfig.get(CAPABILITIES);
    }

    /**
     * Gets the environment defined in gradle.properties.
     *
     * @return a map of environment selected capabilities.
     */
    @SuppressWarnings("unchecked")
    public Map<String, String> getRemoteEnvironments() {
        Map<String, Map<String, String>> env = (Map<String, Map<String, String>>) envConfig.get(ENVIRONMENTS);
        return env.get(REMOTE_SERVER_ENV);
    }
}
