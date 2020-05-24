package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.utils.CommonValidations;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Groups request step definitions.
 */
public class ApiRequestSteps {

    private static final String STATUS_CODE_ERROR_MESSAGE = "Expected status code does not match actual status code.";
    private static final int STATUS_CODE = 200;
    private final Context context;
    private final RequestManager requestManager;
    private Response response;

    /**
     * Initializes an instance of RequestSteps class.
     *
     * @param context scenario context.
     * @param requestManager helper to sending requests.
     */
    public ApiRequestSteps(final Context context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Sets authentication header to base request specification.
     *
     * @param user to set the authentication.
     */
    @Given("I set authentication using {string}")
    public void setAuthentication(final String user) {
        requestManager.setApiCredentials(user);
    }

    /**
     * Sends POST request for required item.
     *
     * @param entity the specific for endPointEnum.
     * @param params request parameters.
     */
    @And("I create (a)(an) {string} with:")
    public void iCreateABoardWith(final String entity, final Map<String, String> params) {
        EndPointsEnum endPointsEnum = CommonValidations.verifyEndPointEnum(entity);
        response = requestManager.init(context).queryParams(params).post(endPointsEnum.getEndPoint());
        context.saveResponse(entity, response);
        context.saveIds(endPointsEnum, response.jsonPath().getString("id"));
        assertEquals(response.getStatusCode(), STATUS_CODE, STATUS_CODE_ERROR_MESSAGE);
    }
}
