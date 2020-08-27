package statements

import environment.Environment
import expressions.UnitExpression
import units.CompositeUnit
import units.DerivedUnit
import values.NumericValue

data class DeclareDerivedUnitStatement(val name: String, val unit: UnitExpression, val coef: NumericValue, val prefix: String?): Statement {
    override fun exec(env: Environment) {
        env.declareUnit(name, DerivedUnit(name, unit.evalUnit(env) as CompositeUnit, coef))
    }
}