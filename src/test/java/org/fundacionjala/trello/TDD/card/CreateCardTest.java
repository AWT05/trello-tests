package org.fundacionjala.trello.TDD.card;

import io.restassured.response.Response;
import org.fundacionjala.trello.client.RequestManager;
import org.fundacionjala.trello.context.Context;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.trello.context.EndPointsEnum.BOARD;
import static org.fundacionjala.trello.context.EndPointsEnum.CARD;
import static org.fundacionjala.trello.context.EndPointsEnum.LIST;
import static org.testng.Assert.assertEquals;

public final class CreateCardTest {

    private static final int STATUS_CODE = 200;
    private RequestManager requestManager;
    private Context context;
    private Response response;

    @BeforeMethod
    public void setAuthenticationAndBackground() {
        context = new Context();
        requestManager = new RequestManager();
        requestManager.setApiCredentials("user1");

        Map<String, String> board = new HashMap<>();
        board.put("name", "Board for card testing");
        response = requestManager.init(context).queryParams(board).post(BOARD.getEndPoint());
        context.saveResponse(BOARD.name().toLowerCase(), response);
        context.saveIds(BOARD.name(), response.jsonPath().getString("id"));

        Map<String, String> list = new HashMap<>();
        list.put("name", "List for card testing");
        list.put("idBoard", "{board.id}");
        response = requestManager.init(context).queryParams(list).post(LIST.getEndPoint());
        context.saveResponse(LIST.name().toLowerCase(), response);
    }

    @AfterMethod
    public void deleteBoard() {
        context.getIdsByKey(BOARD.name())
                .forEach(id -> requestManager.init(context).delete("/boards/".concat(id)));
    }

    @Test
    public void createCardsByApiTest() {
        Map<String, String> card = new HashMap<>();
        card.put("name", "New Card by API");
        card.put("idBoard", "{board.id}");
        card.put("idList", "{list.id}");
        response = requestManager.init(context).queryParams(card).post(CARD.getEndPoint());
        assertEquals(response.getStatusCode(), STATUS_CODE);
    }
}
