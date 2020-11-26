package statements

import environment.Environment
import expressions.Expression
import values.BooleanValue

data class IfElseStatement(val condition: Expression, val body: Expression, val elseBody: Expression): Statement {
    override fun exec(env: Environment) {
        when (val cond = condition.eval(env)) {
            is BooleanValue -> {
                if (cond.v) {
                    env.stateValue(body.eval(env))
                } else {
                    env.stateValue(elseBody.eval(env))
                }
            }
            else -> TODO("make an error for this")
        }
    }
}