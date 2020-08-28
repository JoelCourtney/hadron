package expressions

import environment.Environment
import values.UnitNumericValue
import values.Value

data class UnitConvertExpression(val e: Expression, val u: UnitExpression): Expression {
    override fun eval(env: Environment): Value {
        val left = e.eval(env)
        if (left is UnitNumericValue) {
            return left.convert(u.evalUnit(env))
        } else {
            TODO("make an error for this")
        }
    }
}