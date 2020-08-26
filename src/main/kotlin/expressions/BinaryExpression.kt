package expressions

import environment.Environment
import expressions.BinaryOperation.*
import values.Value

data class BinaryExpression(val bop: BinaryOperation, val left: Expression, val right: Expression): Expression, UnitExpression {
    constructor(bop: String, left: Expression, right: Expression): this(BinaryOperation.fromString(bop), left, right)
    override fun eval(env: Environment): Value {
        return when (bop) {
            ADD -> left.eval(env).add(right.eval(env))
            SUBTRACT -> left.eval(env).subtract(right.eval(env))
            MULTIPLY -> left.eval(env).multiply(right.eval(env))
            DIVIDE -> left.eval(env).divide(right.eval(env))
            EXPONENTIATE -> left.eval(env).exponentiate(right.eval(env))
            LESS_THAN -> left.eval(env).lessThan(right.eval(env))
            GREATER_THAN -> left.eval(env).greaterThan(right.eval(env))
            LESS_THAN_OR_EQUAL -> left.eval(env).lessThanOrEqual(right.eval(env))
            GREATER_THAN_OR_EQUAL -> left.eval(env).greaterThanOrEqual(right.eval(env))
        }
    }
}