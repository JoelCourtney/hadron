package expressions

enum class UnaryOperation {
    NEGATE;

    companion object {
        fun fromString(uop: String): UnaryOperation {
            return when(uop) {
                "-" -> NEGATE
                else -> TODO("make an error for this")
            }
        }
    }
}