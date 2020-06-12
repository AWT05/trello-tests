package org.fundacionjala.core.context;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import java.util.Map;

public class ContextTest {

    @Test
    public void testGetResponses() {
        Context context = new Context();
        Response responseExp = new RestAssuredResponseImpl();
        context.saveResponse("expected", responseExp);

        Map<String, Response> responses = context.getResponses();

        assertTrue(responses.containsKey("expected"));
        assertTrue(responses.containsValue(responseExp));
    }
}
