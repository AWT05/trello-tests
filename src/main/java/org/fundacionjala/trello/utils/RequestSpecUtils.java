package org.fundacionjala.trello.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.trello.config.Environment;

import java.util.Map;

public final class RequestSpecUtils {

    private static final String KEY = "key";
    private static final String TOKEN = "token";
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
        String baseUri = Environment.getInstance().getApiBaseUri();
        return new RequestSpecBuilder().setBaseUri(baseUri).build();

    }

    /**
     * Builds base request specification using API key and token.
     *
     * @param user identifier to get user account.
     * @return base request specification.
     */
    public static RequestSpecification buildAuth(final String user) {
         String baseUri = Environment.getInstance().getApiBaseUri();
         Map<String, String> userAccount = Environment.getInstance().getAccount(user);

        return new RequestSpecBuilder().setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .addQueryParam(KEY, userAccount.get(KEY))
                .addQueryParam(TOKEN, userAccount.get(TOKEN)).build();
    }
}
