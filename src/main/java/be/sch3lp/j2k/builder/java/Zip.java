package be.sch3lp.j2k.builder.java;

import be.sch3lp.j2k.common.ValueObject;

public final class Zip extends ValueObject {
    private final String value;

    private Zip(String value) {
        this.value = value;
    }

    public static Zip zip(String value) {
        return new Zip(value);
    }
}
