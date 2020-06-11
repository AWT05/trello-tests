package org.fundacionjala.core.entities;

import org.fundacionjala.core.Environment;

import java.util.Map;

/**
 * Converts the user data in an object.
 */
public class User {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";
    private static final String API_KEY = "key";
    private static final String API_TOKEN = "token";
    protected final Map<String, String> user;

    public User(final String userAccount) {
        this.user = Environment.getInstance().getAccount(userAccount);
    }

    /**
     * Gets user email.
     *
     * @return user email.
     */
    public String getEmail() {
        return user.get(EMAIL);
    }

    /**
     * Gets username.
     *
     * @return username as string.
     */
    public String getUsername() {
        return user.get(USERNAME);
    }

    /**
     * Gets user password.
     *
     * @return user password.
     */
    public String getPassword() {
        return user.get(PASSWORD);
    }

    /**
     * Gets user api key.
     *
     * @return user api key.
     */
    public String getApiKey() {
        return user.get(API_KEY);
    }

    /**
     * Gets user api token.
     *
     * @return user api token.
     */
    public String getApiToken() {
        return user.get(API_TOKEN);
    }
}
