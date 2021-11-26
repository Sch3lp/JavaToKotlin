package be.sch3lp.j2k.nullability.java;

import be.sch3lp.j2k.common.ValueObject;

import static be.sch3lp.j2k.nullability.java.Validation.validateNotBlank;

public final class ISBN extends ValueObject {
    private final String value;

    private ISBN(final String value) {
        this.value = value;
        validateNotBlank(value, "ISBN");
    }

    public static ISBN isbn(final String value) {
        return new ISBN(value);
    }

    public String asString() {
        return value;
    }
}
