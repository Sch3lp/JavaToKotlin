package be.sch3lp.j2k.valueobjects.java;

final public class Marketing {

    private Marketing() {
        //utility class
    }

    public static boolean isHotmailAddress(EmailAddress emailAddress) {
        return emailAddress.getDomain().equalsIgnoreCase("hotmail.com");
    }
}
