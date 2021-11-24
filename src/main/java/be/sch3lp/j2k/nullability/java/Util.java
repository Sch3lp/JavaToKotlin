package be.sch3lp.j2k.nullability.java;

import java.util.function.Function;

public final class Util {
    private Util() {
        // utility class
    }

    public static <T> Function<T, T> identity() {
        return (it) -> it;
    }
}
