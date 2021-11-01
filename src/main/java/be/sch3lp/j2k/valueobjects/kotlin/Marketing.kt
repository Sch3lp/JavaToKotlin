package be.sch3lp.j2k.valueobjects.kotlin

object Marketing {
    fun isHotmailAddress(emailAddress: EmailAddress): Boolean {
        return emailAddress.domain.equals("hotmail.com", ignoreCase = true)
    }
}