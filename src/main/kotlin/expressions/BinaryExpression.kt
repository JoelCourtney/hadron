package expressions

import environment.Environment
import expressions.BinaryOperation.*
import units.Dimension
import values.Value
import units.Unit
import values.NumericValue

data class BinaryExpression(val bop: BinaryOperation, val left: Expression, val right: Expression): Expression, UnitExpression {
    constructor(bop: String, left: Expression, right: Expression): this(BinaryOperation.fromString(bop), left, right)
    override fun eval(env: Environment): Value {
        return when (bop) {
            ADD -> left.eval(env).add(right.eval(env))
            SUBTRACT -> left.eval(env).subtract(right.eval(env))
            MULTIPLY -> left.eval(env).multiply(right.eval(env))
            DIVIDE -> left.eval(env).divide(right.eval(env))
            EXPONENTIATE -> left.eval(env).exponentiate(right.eval(env))
            EQUAL -> left.eval(env).equal(right.eval(env))
            NOT_EQUAL -> left.eval(env).notEqual(right.eval(env))
            LESS_THAN -> left.eval(env).lessThan(right.eval(env))
            GREATER_THAN -> left.eval(env).greaterThan(right.eval(env))
            LESS_THAN_OR_EQUAL -> left.eval(env).lessThanOrEqual(right.eval(env))
            GREATER_THAN_OR_EQUAL -> left.eval(env).greaterThanOrEqual(right.eval(env))
        }
    }

    override fun evalUnit(env: Environment): Unit {
        val l = left as UnitExpression
        val r = right as UnitExpression
        return when (bop) {
            MULTIPLY -> l.evalUnit(env) multiply r.evalUnit(env)
            DIVIDE -> l.evalUnit(env) divide r.evalUnit(env)
            EXPONENTIATE -> l.evalUnit(env) power right.eval(env) as NumericValue
            else -> TODO("make an error for this")
        }
    }

    override fun evalDimension(env: Environment): Dimension {
        val l = left as UnitExpression
        val r = left as UnitExpression
        return when (bop) {
            MULTIPLY -> l.evalDimension(env) multiply r.evalDimension(env)
            DIVIDE -> l.evalDimension(env) divide r.evalDimension(env)
            EXPONENTIATE -> l.evalDimension(env) power right.eval(env) as NumericValue
            else -> TODO("make an error for this")
        }
    }
}