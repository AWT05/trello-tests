package org.fundacionjala.core.entities;

import org.fundacionjala.core.Environment;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class UserTest {

    private static Environment env = Environment.getInstance();


    @Test
    public void testGetEmail() {
        User user = new User("user1");

        String email = user.getEmail();

        assertNotNull(email);
    }

    @Test
    public void testGetUsername() {
        User user = new User("user1");

        String username = user.getUsername();

        assertNotNull(username);
    }

    @Test
    public void testGetPassword() {
        User user = new User("user1");

        String password = user.getPassword();

        assertNotNull(password);
    }

    @Test
    public void testGetApiKey() {
        User user = new User("user1");

        String apiKey = user.getApiKey();

        assertNotNull(apiKey);
    }

    @Test
    public void testGetApiToken() {
        User user = new User("user1");

        String apiToken = user.getApiToken();

        assertNotNull(apiToken);
    }
}
