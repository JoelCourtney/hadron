package statements

import environment.Environment
import expressions.UnitExpression
import units.BaseDimension
import units.BaseUnit
import units.Dimension

data class DeclareBaseUnitStatement(val name: String, val dim: UnitExpression, val prefix: String?): Statement {
    override fun exec(env: Environment) {
        env.declareUnit(name, BaseUnit(name, dim.evalDimension(env)))
    }
}