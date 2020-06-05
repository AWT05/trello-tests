package org.fundacionjala.trello.context;

import org.fundacionjala.core.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UserTrello extends User {

    private static final String USER = "user";
    private Map<EndPointsEnum, List<String>> mapIds;

    public UserTrello(final String userAccount) {
        super(userAccount);
        this.mapIds = new HashMap<>();
    }

    public String getKeyword() {
        return user.get(USER);
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
     * @param keyword the key whose associated value is to be returned.
     * @return id values.
     */
    public List<String> getIdsByKey(final EndPointsEnum keyword) {
        return mapIds.getOrDefault(keyword, new ArrayList<>());
    }
}
