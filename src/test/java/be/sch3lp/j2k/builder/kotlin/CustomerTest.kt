package be.sch3lp.j2k.builder.kotlin

import org.assertj.core.api.AbstractObjectAssert
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration
import org.junit.jupiter.api.Test

class CustomerTest {

    @Test
    fun `A Customer can be created in an easily readable way`() {
        val customerId = CustomerId()
        val actual = Customer(
            id = customerId,
            age = Age(40u),
            firstName = "Bruce",
            lastName = "Wayne",
            address = Address(
                street = "Vleermuisstraat",
                city = "Dilbeek",
                zip = Zip("1700"),
                houseNumber = "15"
            ),
        )

        assertThat(actual.id).isEqualTo(customerId)
        assertThat(actual.age).isEqualTo(Age(40u))
        assertThat(actual.name).isEqualTo(Name("Bruce", "Wayne"))
        assertThat(actual.address).isEqualTo(
            Address(
                street = "Vleermuisstraat",
                city = "Dilbeek",
                zip = Zip("1700"),
                houseNumber = "15",
                bus = null
            )
        )
    }

    @Test
    fun `A Customer can be created using a TestBuilder`() {
        val expected = Customer(
            id = CustomerId(),
            age = Age(52u),
            firstName = "Edward",
            lastName = "Nigma",
            address = Address(
                street = "Mantelstraat",
                city = "Kruishoutem",
                zip = Zip("9770"),
                houseNumber = "4"
            ),
        )

        assertThat(aDefaultCustomer(
            firstName = "Edward",
            lastName = "Nigma"
        ))
            .withIgnoredFieldsOfTypes(CustomerId::class.java)
            .isEqualTo(expected)
    }
}

private fun <S : AbstractObjectAssert<S, A>, A> AbstractObjectAssert<S, A>.withIgnoredFieldsOfTypes(vararg types: Class<*>) =
    usingRecursiveComparison(
        RecursiveComparisonConfiguration.builder().withIgnoredFieldsOfTypes(*types).build()
    )