package be.sch3lp.j2k.nullability.kotlin

data class ISBN(private val value: String) {
    init {
        validateNotBlank(value, "ISBN")
    }

    fun asString(): String {
        return value
    }
}