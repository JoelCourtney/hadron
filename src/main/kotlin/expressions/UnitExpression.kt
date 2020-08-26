package expressions

import environment.Environment

interface UnitExpression {
    fun evalUnit(env: Environment): Unit
    fun evalDimension(env: Environment): Dimension
}