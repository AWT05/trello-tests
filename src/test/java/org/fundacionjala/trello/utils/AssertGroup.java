package org.fundacionjala.trello.utils;

import org.testng.asserts.Assertion;

public final class AssertGroup {

    private static Assertion assertGroup = new Assertion();

    private AssertGroup() {
    }

    public static Assertion getAssertGroup() {
        return assertGroup;
    }

    public static void setAssertGroup(final Assertion assertGroup) {
        AssertGroup.assertGroup = assertGroup;
    }
}
