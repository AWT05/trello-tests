package org.fundacionjala.trello.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecUtils {

    private static final String AUTHORIZATION_KEY = "key";
    private static final String AUTHORIZATION_TOKEN = "token";
    private static final String BASE_URI = "https://api.trello.com/1";

    /**
     * A private constructor for RequestSpecUtils utility class.
     */
    private RequestSpecUtils() {

    }

    /*
     * Builds base request specification without authentication header.
     *
     * @return base request specification.
     */
    public static RequestSpecification build() {
        // To do
        // String baseUri = Environment.getInstance().getBaseUri();
        return new RequestSpecBuilder().setBaseUri(BASE_URI).build();

    }

    /**
     * Builds base request specification using API key and token.
     *
     * @param user identifier to get user account.
     * @return base request specification.
     */
    public static RequestSpecification buildAuth(final String user) {
        // To do
        // String baseUri = Environment.getInstance().getBaseUri();
        // Map<String, String> account = Environment.getInstance().getAccount(username);

        return new RequestSpecBuilder().setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addQueryParam(AUTHORIZATION_KEY, "f373c0717998475ae74cec4d89b3d5ad")
                .addQueryParam(AUTHORIZATION_TOKEN, "302b974c98dd284f68254b50e220be73577311491d8eb46c9829959b5611f0f8").build();
    }
}
