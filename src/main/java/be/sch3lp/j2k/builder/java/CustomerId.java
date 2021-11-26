package be.sch3lp.j2k.builder.java;

import be.sch3lp.j2k.common.ValueObject;

import java.util.UUID;

public final class CustomerId extends ValueObject {
    private final String id;

    private CustomerId() {
        this.id = UUID.randomUUID().toString();
    }

    private CustomerId(String id) {
        this.id = id;
    }

    public static CustomerId newCustomerId() {
        return new CustomerId();
    }

    public static CustomerId customerIdFromString(String id) {
        return new CustomerId(id);
    }
}
