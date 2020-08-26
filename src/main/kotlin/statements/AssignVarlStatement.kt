package statements

import environment.Environment
import expressions.Expression

data class AssignVarlStatement(val name: String, val exp: Expression): Statement {
    override fun exec(env: Environment) {
        env.assignVarl(name, exp.eval(env))
    }
}