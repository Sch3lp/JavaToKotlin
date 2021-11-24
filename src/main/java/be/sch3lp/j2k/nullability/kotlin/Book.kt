package be.sch3lp.j2k.nullability.kotlin


data class Book(
    val isbn: ISBN,
    val title: String,
    val subtitle: String?, //we don't need to use an unfortunate Optional to represent optional fields
    val author: String
) {
    init {
        validateNotNull(isbn, "ISBN")
        validateNotBlank(title, "Title")
        validateNotBlank(subtitle, "Subtitle")
        validateNotBlank(author, "Author")
    }

    private val subtitleAsString
        get() = subtitle?.let { "- $it" } ?: ""

    fun asString() = "$title $subtitleAsString by $author"

}