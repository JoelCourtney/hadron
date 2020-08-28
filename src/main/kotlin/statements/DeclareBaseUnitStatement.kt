package statements

import environment.Environment
import expressions.UnitExpression
import units.BaseDimension
import units.BaseUnit
import units.DerivedUnit
import units.Dimension
import values.NumericValue

data class DeclareBaseUnitStatement(val name: String, val dim: UnitExpression, val prefix: String?): Statement {
    override fun exec(env: Environment) {
        val base = BaseUnit(name, dim.evalDimension(env) as BaseDimension)
        env.declareUnit(name, base)
        if (prefix != null) {
            val pre = env.getUnitPrefix(prefix)
            for ((p, n) in pre.prefixes) {
                env.declareUnit(p+name, DerivedUnit(p+name, base, n))
            }
        }
    }
}