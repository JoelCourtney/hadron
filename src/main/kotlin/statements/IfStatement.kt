package statements

import environment.Environment
import expressions.Expression
import values.BooleanValue

data class IfStatement(val condition: Expression, val body: Expression): Statement {
    override fun exec(env: Environment) {
        val cond = condition.eval(env)
        when (cond) {
            is BooleanValue -> {
                if (cond.v) {
                    body.eval(env)
                }
            }
            else -> TODO("uhhh not sure")
        }
    }
}