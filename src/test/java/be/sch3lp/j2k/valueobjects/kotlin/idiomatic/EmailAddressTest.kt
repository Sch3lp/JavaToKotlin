package be.sch3lp.j2k.valueobjects.kotlin.idiomatic

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class EmailAddressTest {

    @Test
    fun `A String can be parsed into an EmailAddress when it has 2 parts separated by a @`() {
        Assertions.assertThat("fred@example.com".parseToEmail())
            .isEqualTo(EmailAddress("fred", "example.com"))
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["@", "snarf.at.example.com"])
    fun `These strings cannot be parsed to an EmailAddress`(value: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { value.parseToEmail() }
            .withMessage("EmailAddress must be two parts separated by @")
    }
}