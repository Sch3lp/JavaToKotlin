package be.sch3lp.j2k.nullability.kotlin

class Controller(private val library: Library) {
// uncomment this to see what the Java to Kotlin code would look like
// and check which mistakes it brings to light, thanks to the compiler
//    fun lend(isbn: String?): BookJson {
//        return mapToJson(library.lend(ISBN(isbn)))
//    }
//
//    private fun mapToJson(book: Book?): BookJson {
//        return BookJson(
//            book.author,
//            book.title,
//            book.subtitle,
//            book.isbn.asString()
//        )
//    }

    fun lend(isbn: String?): BookJson? {
        return if (isbn == null) {
            null
        } else {
            library.lend(ISBN(isbn))?.asJson()
        }
    }

    private fun Book.asJson() = BookJson(
        author,
        title,
        subtitle,
        isbn.asString()
    )

    data class BookJson(
        val author: String,
        val title: String,
        val subtitle: String?,
        val isbn: String
    )
}