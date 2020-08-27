package expressions

import environment.Environment
import expressions.Expression
import units.Dimension
import units.Unit
import values.Value

data class IdentifierExpression(val name: String): Expression, UnitExpression {
    override fun eval(env: Environment): Value {
        return env.getVarl(name)
    }

    override fun evalUnit(env: Environment): Unit {
        return env.getUnit(name)
    }

    override fun evalDimension(env: Environment): Dimension {
        return env.getDimension(name)
    }
}