package be.sch3lp.j2k.builder.java;

import java.util.Objects;

public final class Age {
    private final int value;

    private Age(int value) {
        this.value = value;
    }

    public static Age age(int value) {
        return new Age(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Age age = (Age) o;
        return value == age.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
