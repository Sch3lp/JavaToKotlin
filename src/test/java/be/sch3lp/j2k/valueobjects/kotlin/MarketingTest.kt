package be.sch3lp.j2k.valueobjects.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarketingTest {

    @Test
    fun `is Hotmail Address`() {
        assertThat(Marketing.isHotmailAddress(EmailAddress.parse("snarf@hotmail.com"))).isTrue();
        assertThat(Marketing.isHotmailAddress(EmailAddress.parse("snarf@botmail.com"))).isFalse();
        assertThat(Marketing.isHotmailAddress(EmailAddress.parse("hotmail.com@snarf"))).isFalse();
    }
}