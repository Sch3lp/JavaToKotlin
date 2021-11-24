package be.sch3lp.j2k.nullability.java;

import java.util.Map;
import java.util.stream.Stream;

import static be.sch3lp.j2k.nullability.java.ISBN.isbn;
import static be.sch3lp.j2k.nullability.java.Book.book;
import static be.sch3lp.j2k.nullability.java.Util.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public final class DB {

    private final Map<ISBN, Book> books;

    public DB(final Map<ISBN, Book> books) {
        if (books.isEmpty()) {
            this.books = generateBooks();
        } else {
            this.books = books;
        }
    }

    public Book findBy(final ISBN isbn) {
        return books.get(isbn);
    }

    private Map<ISBN, Book> generateBooks() {
        return Stream.of(
                book(
                    isbn("978-1-492-08227-9"),
                    "Java to Kotlin",
                    "A Refactoring Guidebook",
                    "Duncan McGregor & Nat Pryce"
                ),
                book(
                    isbn("0-321-12521-5"),
                    "Domain Driven Design",
                    "Tackling Complexity in the Heart of Software",
                    "Eric Evans"
                ),
                book(
                    isbn("978-0-141-03916-9"),
                    "The Righteous Mind",
                    "Why good people are divided by politics and religion",
                    "Jonathan Haidt"
                ),
                book(
                    isbn("0-226-46801-1"),
                    "Metaphors we live by",
                    null,
                    "George Lakoff and Mark Johnson"
                )
        ).collect(toUnmodifiableMap(Book::getIsbn, identity()));
    }
}
