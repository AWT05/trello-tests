package org.fundacionjala.trello.config;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Reads environment properties.
 */
public final class Environment {

    private static final String ENVIRONMENT = "environmentName";
    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static final String JSON_CONFIG_FILE_PATH = "config.json";
    private static final String ENVIRONMENT_NAME = "name";
    private static final String API_BASE_URI = "apiBaseUri";
    private static final String UI_BASE_URL = "uiBaseUrl";
    private static final String ACCOUNTS = "accounts";
    private static final String USER = "user";
    private static final String ROOT_PATH = ".";
    private static final String IMPLICIT_TIME_WAIT = "implicitTimeWait";
    private static final String EXPLICIT_TIME_WAIT = "explicitTimeWait";
    private static final String BROWSER_WIDTH = "browserWidth";
    private static final String BROWSER_HEIGHT = "browserHeight";
    private static final String REDUCE_EXPLICIT_TIME = "reduceExplicitTime";
    private static Environment instance;

    private final Properties properties;
    private Map<String, Object> envConfig;

    /**
     * Initializes instance of Properties class.
     */
    private Environment() {
        List<Map<String, Object>> environments;
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
            environments = JsonPath.with(Files.readString(Paths.get(JSON_CONFIG_FILE_PATH), StandardCharsets.UTF_8))
                    .getList(ROOT_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Environment config file not found");
        } catch (IOException e) {
            throw new RuntimeException("Input/Output exception, failed to load gradle.properties");
        }
        envConfig = environments.stream().filter(env -> env.get(ENVIRONMENT_NAME).equals(getEnvironmentName()))
                .findFirst().orElse(new HashMap<>());
    }

    /**
     * Gets singleton instance of the EnvironmentReader class.
     *
     * @return EnvironmentReader instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Gets string containing a specific environment property.
     *
     * @param env is the property name string.
     * @return the wanted property value.
     */
    private String getEnvProperty(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return properties.getProperty(env);
        }
        return property;
    }

    /**
     * Gets environment name property.
     *
     * @return environment name.
     */
    public String getEnvironmentName() {
        return getEnvProperty(ENVIRONMENT);
    }

    /**
     * Gets environment base UI URL.
     *
     * @return environment base UI URL.
     */
    public String getUiBaseUrl() {
        return envConfig.get(UI_BASE_URL).toString();
    }

    /**
     * Gets environment base API URI.
     *
     * @return environment base API URI.
     */
    public String getApiBaseUri() {
        return envConfig.get(API_BASE_URI).toString();
    }

    /**
     * Gets account from environment config.
     *
     * @param user account to get user data.
     * @return account json path object.
     */
    @SuppressWarnings("unchecked")
    public Map<String, String> getAccount(final String user) {
        List<Map<String, String>> accounts = (List<Map<String, String>>) envConfig.get(ACCOUNTS);
        return accounts.stream().filter(account -> account.get(USER).equals(user))
                .findFirst().orElse(new HashMap<>());
    }

    /**
     * Gets default implicit time wait.
     *
     * @return int of implicit time.
     */
    public int getImplicitTimeWait() {
        return Integer.parseInt(getEnvProperty(IMPLICIT_TIME_WAIT));
    }

    /**
     * Gets default explicit time wait.
     *
     * @return int of explicit time.
     */
    public int getExplicitTimeWait() {
        return Integer.parseInt(getEnvProperty(EXPLICIT_TIME_WAIT));
    }

    /**
     * Gets default explicit time wait.
     *
     * @return int of explicit time.
     */
    public int getReducedTime() {
        return Integer.parseInt(getEnvProperty(REDUCE_EXPLICIT_TIME));
    }

    /**
     * Gets the width of the browser window.
     *
     * @return the window width.
     */
    public int getBrowserWidth() {
        return Integer.parseInt(getEnvProperty(BROWSER_WIDTH));
    }

    /**
     * Gets the height of the browser window.
     *
     * @return the window height.
     */
    public int getBrowserHeight() {
        return Integer.parseInt(getEnvProperty(BROWSER_HEIGHT));
    }
}
