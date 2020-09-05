package expressions

enum class UnaryOperation {
    NEGATE,
    FACTORIAL;

    companion object {
        fun fromString(uop: String): UnaryOperation {
            return when(uop) {
                "-" -> NEGATE
                "!" -> FACTORIAL
                else -> TODO("make an error for this")
            }
        }
    }
}