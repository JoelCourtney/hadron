package expressions

import environment.Environment
import expressions.Expression
import values.Value

data class IdentifierExpression(val name: String): Expression, UnitExpression {
    override fun eval(env: Environment): Value {
        return env.getVarl(name)
    }
}