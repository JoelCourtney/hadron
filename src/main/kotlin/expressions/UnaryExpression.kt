package expressions

import environment.Environment
import values.Value
import expressions.UnaryOperation.*;
import values.IntegerValue

data class UnaryExpression(val uop: UnaryOperation, val exp: Expression): Expression {
    constructor(uop: String, exp: Expression): this(UnaryOperation.fromString(uop), exp)

    override fun eval(env: Environment): Value {
        return when(uop) {
            NEGATE -> exp.eval(env).negate()
            FACTORIAL -> {
                when (val v = exp.eval(env)) {
                    is IntegerValue -> return v.factorial()
                    else -> throw NotImplementedError()
                }
            }
        }
    }
}