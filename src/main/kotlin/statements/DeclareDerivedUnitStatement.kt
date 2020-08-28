package statements

import environment.Environment
import expressions.UnitExpression
import units.DerivedUnit
import values.NumericValue

data class DeclareDerivedUnitStatement(val name: String, val unit: UnitExpression, val coef: NumericValue, val prefix: String?): Statement {
    override fun exec(env: Environment) {
        val derivedFrom = unit.evalUnit(env)
        env.declareUnit(name, DerivedUnit(name, derivedFrom, coef))
        if (prefix != null) {
            val pre = env.getUnitPrefix(prefix)
            for ((p, n) in pre.prefixes) {
                env.declareUnit(p+name, DerivedUnit(p+name, derivedFrom, coef.multiply(n) as NumericValue))
            }
        }
    }
}