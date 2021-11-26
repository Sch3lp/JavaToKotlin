package be.sch3lp.j2k.valueobjects.java;

import be.sch3lp.j2k.common.ValueObject;

final public class EmailAddress extends ValueObject {

    private final String localPart;
    private final String domain;

    public EmailAddress(String localPart, String domain) {
        this.localPart = localPart;
        this.domain = domain;
    }

    @Override
    public String toString() {
        return localPart + "@" + domain;
    }

    public static EmailAddress parse(String value) {
        var atIndex = value.lastIndexOf('@');
        if (atIndex < 1 || atIndex == value.length() - 1)
            throw new IllegalArgumentException("EmailAddress must be two parts separated by @");
        return new EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
        );
    }

    public String getLocalPart() {
        return localPart;
    }

    public String getDomain() {
        return domain;
    }
}
