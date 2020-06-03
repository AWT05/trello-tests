package org.fundacionjala.trello.entities;

import org.fundacionjala.trello.config.Environment;

import java.util.Map;

/**
 * Converts the user data in an object.
 */
public final class User {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";
    private final Map<String, String> user;

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
        return user.get("key");
    }

    /**
     * Gets user api token.
     *
     * @return user api token.
     */
    public String getApiToken() {
        return user.get("token");
    }
}
