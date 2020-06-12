package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.context.UserTrello;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.utils.CommonValidations;

import java.util.HashMap;
import java.util.Map;

/**
 * Groups request step definitions.
 */
public class ApiRequestStepDef {

    private static final String INVITE_MEMBER_END_POINT = "/boards/{board.id}/members/";
    private static final String TYPE = "type";
    private static final String ID = "id";
    private final ContextTrello context;
    private final RequestManager requestManager;
    private Response response;

    /**
     * Initializes an instance of RequestSteps class.
     *
     * @param sharedDriver   init driver.
     * @param context        scenario context.
     * @param requestManager helper to sending requests.
     */
    public ApiRequestStepDef(
            final SharedDriver sharedDriver,
            final ContextTrello context,
            final RequestManager requestManager) {
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
        context.saveUser(user);
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
        context.getUser().saveIds(endPointsEnum, response.jsonPath().getString(ID));
    }

    /**
     * Sends PUT request for add members in to a board.
     *
     * @param data request parameters with user and type.
     */
    @Given("I invite a member by setting its type with:")
    public void iInviteAsMemberWith(final Map<String, String> data) {
        Map<String, String> params = new HashMap<>();
        data.forEach((key, value) -> {
            params.put(TYPE, value);
            requestManager.init(context).queryParams(params)
                    .put(INVITE_MEMBER_END_POINT.concat(new UserTrello(key).getUsername()));
        });
    }
}
