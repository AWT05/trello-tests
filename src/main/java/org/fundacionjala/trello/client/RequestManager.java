package org.fundacionjala.trello.client;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.utils.Mapper;
import org.fundacionjala.trello.utils.RequestSpecUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class RequestManager {

    private Context context;
    private RequestSpecification requestSpec;
    private RequestSpecification requestSpecInit;

    public RequestManager() {
        requestSpecInit = RequestSpecUtils.build();
    }

    /**
     * Initialize the request specification, cleaning any parameters.
     *
     * @param context when save the request specification.
     * @return the request manager object.
     */
    public RequestManager init(final Context context) {
        this.context = context;
        this.requestSpec = requestSpecInit;
        return this;
    }

    public void authenticate(final String user) {
        requestSpecInit = RequestSpecUtils.buildAuth(user);
    }

    /**
     * Sets the query parameters that'll be in the base request specification.
     *
     * @param data contains the parameter keys and their values to send with the request.
     * @return the request manager object.
     */
    public RequestManager queryParams(final Map<String, String> data) {
        requestSpec = given(requestSpec).queryParams(mapOut(data));
        return this;
    }

    /**
     * Sets the body that'll be in the base request specification.
     *
     * @param data contains the string body to send.
     * @return the request manager object.
     */
    public RequestManager body(final String data) {
        requestSpec = given(requestSpec).body(mapOut(data));
        return this;
    }

    /**
     * Sends a GET request to an <code>endpoint</code>.
     *
     * @param endpoint The path to send the request to.
     * @return The response of the request.
     */
    public Response get(final String endpoint) {
        return given(requestSpec).when().get(mapOut(endpoint));
    }

    /**
     * Sends a DELETE request to an <code>endpoint</code>.
     *
     * @param endpoint The path to send the request to.
     * @return The response of the request.
     */
    public Response delete(final String endpoint) {
        return given(requestSpec).when().delete(mapOut(endpoint));
    }

    /**
     * Sends a POST request to an <code>endpoint</code>.
     *
     * @param endpoint The path to send the request to.
     * @return The response of the request.
     */
    public Response post(final String endpoint) {
        return given(requestSpec).when().post(mapOut(endpoint));
    }


    /**
     * Sends a PUT request to an <code>endpoint</code>.
     *
     * @param endpoint The path to send the request to.
     * @return The response of the request.
     */
    public Response put(final String endpoint) {
        return given(requestSpec).when().put(mapOut(endpoint));
    }

    /**
     * Prints response value in console.
     */
    public static void displayFiltersData() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    private String mapOut(final String endpoint) {
        return Mapper.replaceData(endpoint, context.getResponses());
    }

    private Map<String, String> mapOut(final Map<String, String> data) {
        return Mapper.replaceData(data, context.getResponses());
    }
}
