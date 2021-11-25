package be.sch3lp.j2k.builder.kotlin

import java.util.*

data class Customer(
    val id: CustomerId,
    val name: Name,
    val address: Address,
    val age: Age
) {
    constructor(
        id: CustomerId,
        firstName: String,
        lastName: String,
        address: Address,
        age: Age
    ) : this(id, Name(firstName, lastName), address, age)
}

data class CustomerId(private val id: String = UUID.randomUUID().toString())
data class Name(private val firstName: String, private val lastName: String)
@JvmInline
value class Age(private val value: UInt)