package org.fundacionjala.trello.pages;

import org.fundacionjala.trello.context.EndPointsEnum;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.team.TeamPage;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class IdentifiableFactory {

    private IdentifiableFactory() {

    }

    public static IIdentifiable getIdentifiable(final EndPointsEnum element) {
        switch (element) {
            case BOARD:
                return new BoardPage(getDriver());
            case TEAM:
                return new TeamPage(getDriver());
            default:
                throw new IllegalArgumentException();
        }
    }
}
