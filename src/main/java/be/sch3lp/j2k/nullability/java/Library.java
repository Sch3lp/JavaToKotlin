package be.sch3lp.j2k.nullability.java;

public final class Library {

    private final DB db;

    // Assume some injection framework injects a non null instance
    public Library(final DB db) {
        this.db = db;
    }

    public Book lend(final ISBN isbn) {
        return db.findBy(isbn);
    }
}
