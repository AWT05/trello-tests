package org.fundacionjala.trello.context;

import io.restassured.response.Response;
import org.fundacionjala.trello.pages.trello.TrelloPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Context {

    private TrelloPage trelloPage;
    private Map<String, Response> responses;
    private Map<EndPointsEnum, List<String>> mapIds;

    /**
     * Initializes an instance of Context class.
     */
    public Context() {
        initializeValues();
    }

    /**
     * Initializes context values.
     */
    public void initializeValues() {
        responses = new HashMap<>();
        mapIds = new HashMap<>();
        trelloPage = null;
    }

    /**
     * Saves response according to key.
     *
     * @param keyword  key identifier.
     * @param response response object.
     */
    public void saveResponse(final String keyword, final Response response) {
        responses.put(keyword, response);
    }

    /**
     * Gets context responses.
     *
     * @return context responses.
     */
    public Map<String, Response> getResponses() {
        return responses;
    }

    /**
     * Saves id in a map.
     *
     * @param keyword map key.
     * @param id      project id.
     */
    public void saveIds(final EndPointsEnum keyword, final String id) {
        if (!mapIds.containsKey(keyword)) {
            mapIds.put(keyword, new ArrayList<>());
        }
        mapIds.get(keyword).add(id);
    }

    /**
     * Gets saved map by key.
     *
     * @param keyword map key.
     * @return id values.
     */
    public List<String> getIdsByKey(final EndPointsEnum keyword) {
        return mapIds.getOrDefault(keyword, new ArrayList<>());
    }

    public void saveActualPage(final TrelloPage page) {
        trelloPage = page;
    }

    public TrelloPage getActualPage() {
        return trelloPage;
    }
}
