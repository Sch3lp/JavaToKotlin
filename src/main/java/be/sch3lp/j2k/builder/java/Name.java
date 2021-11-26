package be.sch3lp.j2k.builder.java;

import be.sch3lp.j2k.common.ValueObject;

public final class Name extends ValueObject {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
