package be.sch3lp.j2k.builder.java;

import be.sch3lp.j2k.common.ValueObject;

public final class Age extends ValueObject {
    private final int value;

    private Age(int value) {
        this.value = value;
    }

    public static Age age(int value) {
        return new Age(value);
    }
}
