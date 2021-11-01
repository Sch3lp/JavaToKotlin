package be.sch3lp.j2k.valueobjects.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarketingTest {

    @Test
    void isHotmailAddress() {
        assertThat(Marketing.isHotmailAddress(EmailAddress.parse("snarf@hotmail.com"))).isTrue();
        assertThat(Marketing.isHotmailAddress(EmailAddress.parse("snarf@botmail.com"))).isFalse();
        assertThat(Marketing.isHotmailAddress(EmailAddress.parse("hotmail.com@snarf"))).isFalse();
    }
}
