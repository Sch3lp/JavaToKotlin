package be.sch3lp.j2k.nullability.java;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import static be.sch3lp.j2k.nullability.java.Validation.*;

public final class Book {
    private final ISBN isbn;
    private final String title;
    private final String subtitle;
    private final String author;

    private Book(final ISBN isbn,
                 final String title,
                 @Nullable final String subtitle,
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
                            @Nullable final String subtitle,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(subtitle, book.subtitle) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subtitle, author);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("isbn=" + isbn)
                .add("title='" + title + "'")
                .add("subtitle='" + subtitle + "'")
                .add("author='" + author + "'")
                .toString();
    }

}
