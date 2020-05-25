package org.fundacionjala.trello.TDD.lists;

import io.restassured.response.Response;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.fundacionjala.trello.context.EndPointsEnum.LIST;
import static org.testng.Assert.assertEquals;

public final class UpdateListTest {
    private static final int STATUS_CODE = 200;
    private RequestManager requestManager;
    private Context context;
    private Response response;

    @BeforeMethod
    public void setAuthenticationAndBackGround() {
        context = new Context();
        requestManager = new RequestManager();
        requestManager.setApiCredentials("user1");
        //all steps to create a board
        Map<String, String> board = new HashMap<>();
        board.put("name", "new Board to test a list");
        response = requestManager.init(context).queryParams(board).post(BOARD.getEndPoint());
        context.saveResponse(BOARD.name().toLowerCase(), response);
        context.saveIds(BOARD, response.jsonPath().getString("id"));
        //all steps to create a list
        Map<String, String> list = new HashMap<>();
        list.put("name", "New list test api");
        list.put("idBoard", "{board.id}");
        response = requestManager.init(context).queryParams(list).post(LIST.getEndPoint());
        context.saveResponse(LIST.name().toLowerCase(), response);
    }

    @Test
    public void updateAListApiTest() {
        String endPoint = LIST.getEndPoint().concat("/{list.id}");
        Map<String, String> updateList = new HashMap<>();
        updateList.put("name", "New list Updated");
        response = requestManager.init(context).queryParams(updateList).put(endPoint);
        assertEquals(response.getStatusCode(), STATUS_CODE);
    }

    @AfterMethod
    public void deleteBoard() {
        context.getIdsByKey(BOARD)
                .forEach(id -> requestManager.init(context).delete("/boards/".concat(id)));
    }
}
