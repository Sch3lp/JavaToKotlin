package be.sch3lp.j2k.nullability.kotlin

internal fun validateNotNull(value: Any?, field: String) {
    requireNotNull(value) { "$field cannot be null." }
}

internal fun validateNotBlank(value: String?, field: String) {
    require(value?.isNotBlank() ?: true) { "$field cannot be empty or blank." }
}