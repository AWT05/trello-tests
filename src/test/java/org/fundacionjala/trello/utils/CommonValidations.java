package org.fundacionjala.trello.utils;

import org.fundacionjala.trello.context.EndPointsEnum;

/**
 * Groups methods to use common validations.
 */
public final class CommonValidations {

    private static final String ILLEGAL_ARGUMENT_MESSAGE = "Error <%s> is not a valid field";

    private CommonValidations() {
    }

    /**
     * Verifies whether the item is an enum.
     *
     * @param entity string of the item.
     * @return entity verified as enum.
     */
    public static EndPointsEnum verifyEndPointEnum(final String entity) {
        EndPointsEnum endPointsEnum;
        try {
            endPointsEnum = EndPointsEnum.valueOf(entity.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        return endPointsEnum;
    }
}
