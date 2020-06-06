package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.context.UserTrello;
import org.fundacionjala.trello.utils.CommonValidations;

import java.util.Map;

/**
 * Groups request step definitions.
 */
public class ApiRequestStepDef {

    private static final String INVITE_MEMBER_END_POINT = "/boards/{board.id}/members/";
    private static final String ID = "id";
    private final ContextTrello context;
    private final RequestManager requestManager;
    private Response response;

    /**
     * Initializes an instance of RequestSteps class.
     *
     * @param context        scenario context.
     * @param requestManager helper to sending requests.
     */
    public ApiRequestStepDef(final ContextTrello context, final RequestManager requestManager) {
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
     * Sends PUT request for add a member in to a board.
     *
     * @param userAccount to get a user data.
     * @param params request parameters.
     */
    @Given("I invite {string} as member with:")
    public void iInviteAsMemberWith(final String userAccount, final Map<String, String> params) {
        UserTrello user = new UserTrello(userAccount);
        String endPointAddMember = INVITE_MEMBER_END_POINT.concat(user.getIdMember());
        requestManager.init(context).queryParams(params).put(endPointAddMember);
    }
}
