package be.sch3lp.j2k.builder.java;

import java.util.Objects;
import java.util.UUID;

public final class CustomerId {
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

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerId that = (CustomerId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
