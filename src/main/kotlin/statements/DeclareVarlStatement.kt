package statements

import environment.Environment
import expressions.Expression

data class DeclareVarlStatement(val name: String, val exp: Expression, val mutable: Boolean): Statement {
    override fun exec(env: Environment) {
        env.declareVarl(name, exp.eval(env), mutable)
    }
}