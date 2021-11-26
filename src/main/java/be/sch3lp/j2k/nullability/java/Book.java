package be.sch3lp.j2k.nullability.java;

import be.sch3lp.j2k.common.ValueObject;

import java.util.Optional;

import static be.sch3lp.j2k.nullability.java.Validation.*;

public final class Book extends ValueObject {
    private final ISBN isbn;
    private final String title;
    private final String subtitle;
    private final String author;

    private Book(final ISBN isbn,
                 final String title,
                 final String subtitle,
                 final String author) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        validateNotNull(isbn, "ISBN");
        validateNotBlank(title, "Title");
        validateNullOrNotBlank(subtitle, "Subtitle");
        validateNotBlank(author, "Author");
    }

    public static Book book(final ISBN isbn,
                            final String title,
                            final String subtitle,
                            final String author) {
        return new Book(isbn, title, subtitle, author);
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Optional<String> getSubtitle() {
        return Optional.of(subtitle);
    }

    private String subtitleAsString() {
        return getSubtitle().map(it -> "- " + it).orElse("");
    }

    public String asString() {
        return String.format("%s %s by %s",
                title,
                subtitleAsString(),
                author);
    }
}
