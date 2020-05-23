package org.fundacionjala.trello.TDD;

import io.restassured.response.Response;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.context.KeywordsEnum.BOARD;
import static org.testng.Assert.assertEquals;

public class CreateBoardTest {

    RequestManager requestManager;
    Context context;

    @BeforeMethod
    public void setAuthentication() {
        context = new Context();
        requestManager = new RequestManager();
        requestManager.authenticate("user1");
        RequestManager.displayFiltersData();
    }

    @Test
    public void createPersonalBoardByApiTest() {
        Map<String, String> data = new HashMap<>();
        data.put("name", "Test GUI");
        String uri = "/boards";
        Response response = requestManager.init(context)
                                          .queryParams(data)
                                          .post(uri);
        String id = response.jsonPath().getString("id");
        context.saveIds(BOARD, id);
        assertEquals(response.getStatusCode(), 200);
    }

    @AfterMethod
    public void deleteBoard() {
        context.getIdsByKey(BOARD)
                .forEach(id -> {
                    requestManager.init(context)
                                  .delete("/boards/".concat(id));
                });
    }
}
