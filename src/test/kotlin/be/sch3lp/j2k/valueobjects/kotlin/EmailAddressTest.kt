package be.sch3lp.j2k.valueobjects.kotlin

import be.sch3lp.j2k.valueobjects.java.EmailAddress
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class EmailAddressTest {
    @Test
    fun parsing() {
        assertThat(EmailAddress.parse("fred@example.com"))
            .isEqualTo(EmailAddress("fred", "example.com"))
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["@", "snarf.at.example.com"])
    fun parsingFailures(value: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { EmailAddress.parse(value) }
            .withMessage("EmailAddress must be two parts separated by @")
    }
}