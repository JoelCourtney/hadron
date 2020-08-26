package expressions

import environment.Environment
import values.Value
import expressions.UnaryOperation.*;

data class UnaryExpression(val uop: UnaryOperation, val exp: Expression): Expression {
    constructor(uop: String, exp: Expression): this(UnaryOperation.fromString(uop), exp)

    override fun eval(env: Environment): Value {
        return when(uop) {
            NEGATE -> exp.eval(env).negate()
        }
    }
}