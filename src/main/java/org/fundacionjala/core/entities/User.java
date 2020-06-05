package org.fundacionjala.core.entities;

import org.fundacionjala.core.Environment;

import java.util.Map;

/**
 * Converts the user data in an object.
 */
public class User {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
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
