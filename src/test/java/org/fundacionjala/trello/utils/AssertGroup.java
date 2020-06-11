package org.fundacionjala.trello.utils;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public final class AssertGroup {

    private Assertion assertGroup;

    public AssertGroup() {
        assertGroup = new Assertion();
    }

    public Assertion getAssertGroup() {
        return assertGroup;
    }

    public void setAssertGroup(final Assertion assertGroup) {
        this.assertGroup = assertGroup;
    }

    public void assertAll() {
        ((SoftAssert) assertGroup).assertAll();
    }
}
