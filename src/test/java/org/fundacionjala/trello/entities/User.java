package org.fundacionjala.trello.entities;

import org.fundacionjala.trello.config.Environment;

import java.util.Map;

public class User {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private final Map<String, String> user;

    public User(String userAccount) {
        this.user = Environment.getInstance().getAccount(userAccount);
    }

    public String getEmail() {
        return user.get(EMAIL);
    }

    public String getPassword() {
        return user.get(PASSWORD);
    }

    public String getApiKey() {
        return user.get("key");
    }

    public String getApiToken() {
        return user.get("token");
    }
}
