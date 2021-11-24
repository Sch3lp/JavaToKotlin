package be.sch3lp.j2k.nullability.java;

import static be.sch3lp.j2k.nullability.java.ISBN.isbn;

public class Controller {

    private final Library library;

    // Assume some injection framework injects a non null instance
    public Controller(final Library library) {
        this.library = library;
    }

    public BookJson lend(final String isbn) {
        return mapToJson(library.lend(isbn(isbn)));
    }

    private BookJson mapToJson(Book book) {
        return new BookJson(
                book.getAuthor(),
                book.getTitle(),
                book.getSubtitle().orElse(null),
                book.getIsbn().asString()
        );
    }

    public static class BookJson {

        private final String author;
        private final String title;
        private final String subtitle;
        private final String isbn;

        public BookJson(final String author,
                        final String title,
                        final String subtitle,
                        final String isbn) {
            this.author = author;
            this.title = title;
            this.subtitle = subtitle;
            this.isbn = isbn;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getIsbn() {
            return isbn;
        }
    }
}
