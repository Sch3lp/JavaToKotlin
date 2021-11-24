package be.sch3lp.j2k.nullability.kotlin

class Library(private val db: DB) {

    fun lend(isbn: ISBN): Book? {
        return db.findBy(isbn)
    }
}