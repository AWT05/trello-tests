package org.fundacionjala.trello.pages;

import java.net.URISyntaxException;

public interface IIdentifier {
    default String getIdentifier() {
        String identifier = "";
        try {
            identifier = handleUrl();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return identifier;
    }

    String handleUrl() throws URISyntaxException;
}
