package expressions

import environment.Environment
import units.Dimension
import units.Unit

interface UnitExpression {
    fun evalUnit(env: Environment): Unit
    fun evalDimension(env: Environment): Dimension
}