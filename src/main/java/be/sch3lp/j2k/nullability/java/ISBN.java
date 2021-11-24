package be.sch3lp.j2k.nullability.java;

import java.util.Objects;
import java.util.StringJoiner;

import static be.sch3lp.j2k.nullability.java.Validation.validateNotBlank;

public final class ISBN {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ISBN isbn = (ISBN) o;
        return Objects.equals(value, isbn.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ISBN.class.getSimpleName() + "[", "]")
                .add("value='" + value + "'")
                .toString();
    }
}
