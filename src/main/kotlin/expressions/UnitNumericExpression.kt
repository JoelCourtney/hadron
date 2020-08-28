package expressions

import environment.Environment
import values.NumericValue
import values.UnitNumericValue
import values.Value

data class UnitNumericExpression(val n: NumericValue, val u: UnitExpression): Expression {
    override fun eval(env: Environment): Value {
        return UnitNumericValue(n, u.evalUnit(env))
    }
}