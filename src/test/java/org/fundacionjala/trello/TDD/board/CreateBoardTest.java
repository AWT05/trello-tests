package org.fundacionjala.trello.TDD.board;

import io.restassured.response.Response;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.testng.Assert.assertEquals;

public final class CreateBoardTest {

    private static final int STATUS_CODE = 200;
    private RequestManager requestManager;
    private Context context;

    @BeforeMethod
    public void setAuthentication() {
        context = new Context();
        requestManager = new RequestManager();
        requestManager.setApiCredentials("user1");
        RequestManager.displayFiltersData();
    }

    @Test
    public void createPersonalBoardByApiTest() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "Test GUI");
        String endpoint = "/boards";
        Response response = requestManager.init(context)
                .queryParams(data)
                .post(endpoint);
        String id = response.jsonPath().getString("id");
        context.saveIds(BOARD.name(), id);
        assertEquals(response.getStatusCode(), STATUS_CODE);
    }

    @AfterMethod
    public void deleteBoard() {
        context.getIdsByKey(BOARD.name())
                .forEach(id -> requestManager.init(context)
                        .delete("/boards/".concat(id)));
    }
}
