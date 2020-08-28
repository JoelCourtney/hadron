package statements

import environment.Environment
import expressions.UnitExpression
import units.CompositeDimension
import units.DerivedDimension

data class DeclareDerivedDimensionStatement(val name: String, val dim: UnitExpression): Statement {
    override fun exec(env: Environment) {
        env.declareDimension(name, DerivedDimension(name, dim.evalDimension(env)))
    }
}