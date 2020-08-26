package statements

import environment.Environment
import expressions.Expression

data class ValueStatement(val v: Expression): Statement {
    override fun exec(env: Environment) {
        env.stateValue(v.eval(env))
    }
}