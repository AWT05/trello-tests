package org.fundacionjala.trello.context;

public enum EndPointsEnum {
    BOARD("/boards/"),
    CARD("/cards/"),
    LIST("/lists/"),
    TEAM("/organizations/");

    private final String endPoint;

    /**
     * Set EndPointsEnum with specific data.
     *
     * @param endPoint for each enum.
     */
    EndPointsEnum(final String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Gets a specific endPoint.
     *
     * @return a string with endPoint.
     */
    public String getEndPoint() {
        return endPoint;
    }
}
