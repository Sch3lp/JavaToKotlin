package be.sch3lp.j2k.valueobjects.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmailAddressTest {

    @Test
    @DisplayName("A String can be parsed into an EmailAddress when it has 2 parts separated by a @")
    void parsing() {
        assertThat(EmailAddress.parse("fred@example.com"))
                .isEqualTo(new EmailAddress("fred", "example.com"));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"@", "snarf.at.example.com"})
    @DisplayName("These strings cannot be parsed to an EmailAddress")
    void parsingFailures(final String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> EmailAddress.parse(value))
                .withMessage("EmailAddress must be two parts separated by @");
    }
}