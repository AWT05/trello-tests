package org.fundacionjala.trello.context;

import io.restassured.response.Response;
import org.fundacionjala.trello.pages.core.PageObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

    private PageObject pageObject;
    private Map<String, Response> responses;
    private Map<String, List<String>> mapIds;

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
        pageObject = null;
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
    public void saveIds(final String keyword, final String id) {
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
    public List<String> getIdsByKey(final String keyword) {
        return mapIds.getOrDefault(keyword, new ArrayList<>());
    }

    /**
     * Saves the actual page in the context.
     *
     * @param page actual page.
     */
    public void saveActualPage(final PageObject page) {
        pageObject = page;
    }

    /**
     * Gets the pages saved.
     *
     * @return actual page.
     */
    public PageObject getActualPage() {
        return pageObject;
    }
}
