package be.sch3lp.j2k.nullability.kotlin

class DB(books: Map<ISBN, Book>) {
    private val books: Map<ISBN, Book>

    init {
        if (books.isEmpty()) {
            this.books = generateBooks()
        } else {
            this.books = books
        }
    }

    fun findBy(isbn: ISBN): Book? {
        return books[isbn]
    }
}

private fun generateBooks(): Map<ISBN, Book> {
    return listOf(
        Book(
            ISBN("978-1-492-08227-9"),
            "Java to Kotlin",
            "A Refactoring Guidebook",
            "Duncan McGregor & Nat Pryce"
        ),
        Book(
            ISBN("0-321-12521-5"),
            "Domain Driven Design",
            "Tackling Complexity in the Heart of Software",
            "Eric Evans"
        ),
        Book(
            ISBN("978-0-141-03916-9"),
            "The Righteous Mind",
            "Why good people are divided by politics and religion",
            "Jonathan Haidt"
        ),
        Book(
            ISBN("0-226-46801-1"),
            "Metaphors we live by",
            null,
            "George Lakoff and Mark Johnson"
        )
    ).associateBy { it.isbn }.toMap() // no identity() function needed
}
