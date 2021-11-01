package be.sch3lp.j2k.valueobjects.kotlin.idiomatic

data class EmailAddress(
    val localPart: String,
    val domain: String
) {
    override fun toString(): String {
        return "$localPart@$domain"
    }
}

internal fun String.parseToEmail(): EmailAddress {
    val parts = split('@', limit = 2).filterNot { it.isBlank() }
    require(parts.size == 2) { "EmailAddress must be two parts separated by @" }
    val (localPart, domain) = parts
    return EmailAddress(localPart, domain)
}
