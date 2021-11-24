package be.sch3lp.j2k.nullability.java;

public final class Validation {

    private Validation() {
        // noop utility class
    }

    public static void validateNotNull(final Object value, final String field) {
        if (value == null) {
            throw new IllegalArgumentException(String.format("%s cannot be null.", field));
        }
    }

    public static void validateNullOrNotBlank(final String value, final String field) {
        if (value != null && (value.equals("") || value.equals(" "))) {
            throw new IllegalArgumentException(String.format("%s cannot be empty or blank.", field));
        }
    }

    public static void validateNotBlank(final String value, final String field) {
        validateNotNull(value, field);
        validateNullOrNotBlank(value, field);
    }
}
