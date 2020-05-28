package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.utils.CommonValidations;

import java.util.Map;

/**
 * Groups request step definitions.
 */
public class ApiRequestStepDef {

    private final Context context;
    private final RequestManager requestManager;
    private Response response;

    /**
     * Initializes an instance of RequestSteps class.
     *
     * @param context        scenario context.
     * @param requestManager helper to sending requests.
     */
    public ApiRequestStepDef(final Context context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Sets authentication header to base request specification.
     *
     * @param user to set the authentication.
     */
    @Given("I authenticate as {string}")
    public void setAuthentication(final String user) {
        requestManager.setApiCredentials(user);
    }

    /**
     * Sends POST request for required item.
     *
     * @param entity specific for endPointEnum.
     * @param params request parameters.
     */
    @Given("I create (a)(an) {string} with:")
    public void iCreateAItemWith(final String entity, final Map<String, String> params) {
        EndPointsEnum endPointsEnum = CommonValidations.verifyEndPointEnum(entity);
        response = requestManager.init(context).queryParams(params).post(endPointsEnum.getEndPoint());
        context.saveResponse(entity, response);
        context.saveIds(endPointsEnum, response.jsonPath().getString("id"));
    }

    @And("I invite {string} as member with:")
    public void iInviteAsMemberWith(String user) {
    }
}
