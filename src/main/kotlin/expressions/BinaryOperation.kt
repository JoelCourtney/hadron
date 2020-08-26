package expressions

enum class BinaryOperation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    EXPONENTIATE;

    companion object {
        fun fromString(s: String): BinaryOperation {
            return when(s) {
                "+" -> ADD
                "-" -> SUBTRACT
                "*" -> MULTIPLY
                "/" -> DIVIDE
                "^" -> EXPONENTIATE
                else -> TODO("make an error for this")
            }
        }
    }
}