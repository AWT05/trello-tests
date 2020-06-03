package org.fundacionjala.trello.TDD.lists;

import io.restassured.response.Response;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.core.context.Context;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.fundacionjala.trello.context.EndPointsEnum.LIST;
import static org.testng.Assert.assertEquals;

public final class CreateListTest {

    private static final int STATUS_CODE = 200;
    private RequestManager requestManager;
    private Context context;
    private Response response;

    @BeforeMethod
    public void setAuthenticationAndBackGround() {
        context = new Context();
        requestManager = new RequestManager();
        requestManager.setApiCredentials("user1");

        Map<String, String> board = new HashMap<>();
        board.put("name", "new Board to test a list");
        response = requestManager.init(context).queryParams(board).post(BOARD.getEndPoint());
        context.saveResponse(BOARD.name().toLowerCase(), response);
        context.saveIds(BOARD.name(), response.jsonPath().getString("id"));
    }

    @Test
    public void createAListApiTest() {
        Map<String, String> list = new HashMap<>();
        list.put("name", "New list test api");
        list.put("idBoard", "{board.id}");
        response = requestManager.init(context).queryParams(list).post(LIST.getEndPoint());
        assertEquals(response.getStatusCode(), STATUS_CODE);
    }

    @AfterMethod
    public void deleteBoard() {
        context.getIdsByKey(BOARD.name())
                .forEach(id -> requestManager.init(context).delete("/boards/".concat(id)));
    }
}
