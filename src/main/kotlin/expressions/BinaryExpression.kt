package expressions

import environment.Environment
import expressions.BinaryOperation.*
import values.Value

data class BinaryExpression(val bop: BinaryOperation, val left: Expression, val right: Expression): Expression {
    constructor(bop: String, left: Expression, right: Expression): this(BinaryOperation.fromString(bop), left, right)
    override fun eval(env: Environment): Value {
        return when (bop) {
            ADD -> left.eval(env).add(right.eval(env))
            SUBTRACT -> left.eval(env).subtract(right.eval(env))
            MULTIPLY -> left.eval(env).multiply(right.eval(env))
            DIVIDE -> left.eval(env).divide(right.eval(env))
            EXPONENTIATE -> left.eval(env).exponentiate(right.eval(env))
        }
    }
}