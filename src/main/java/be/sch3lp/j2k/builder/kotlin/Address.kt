package be.sch3lp.j2k.builder.kotlin

data class Address(
    val street: String,
    val city: String,
    val zip: Zip,
    val houseNumber: String,
    val bus: String? = null
)

@JvmInline
value class Zip(private val value: String)