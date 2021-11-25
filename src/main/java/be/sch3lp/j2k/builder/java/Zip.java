package be.sch3lp.j2k.builder.java;

import java.util.Objects;

public final class Zip {
    private final String value;

    private Zip(String value) {
        this.value = value;
    }

    public static Zip zip(String value) {
        return new Zip(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zip zip = (Zip) o;
        return Objects.equals(value, zip.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
