package values

import values.BinaryOperation.*

data class BinaryExpression(val bop: BinaryOperation, val left: Value, val right: Value): Expression {
    override fun eval(): Value {
        return when (bop) {
            ADD -> left.eval().add(right.eval())
            SUBTRACT -> left.eval().subtract(right.eval())
            MULTIPLY -> left.eval().multiply(right.eval())
            DIVIDE -> left.eval().divide(right.eval())
            EXPONENTIATE -> left.eval().exponentiate(right.eval())
        }
    }
}