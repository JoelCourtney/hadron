package expressions

enum class BinaryOperation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    EXPONENTIATE,
    EQUAL,
    NOT_EQUAL,
    LESS_THAN,
    GREATER_THAN,
    LESS_THAN_OR_EQUAL,
    GREATER_THAN_OR_EQUAL;

    companion object {
        fun fromString(s: String): BinaryOperation {
            return when(s) {
                "+" -> ADD
                "-" -> SUBTRACT
                "*" -> MULTIPLY
                "/" -> DIVIDE
                "^" -> EXPONENTIATE
                "==" -> EQUAL
                "!=" -> NOT_EQUAL
                "<" -> LESS_THAN
                ">" -> GREATER_THAN
                "<=" -> LESS_THAN_OR_EQUAL
                ">=" -> GREATER_THAN_OR_EQUAL
                else -> TODO("make an error for this")
            }
        }
    }
}