package statements

import environment.Environment
import expressions.Expression
import values.FunctionValue

data class DeclareFunctionStatement(val name: String, val args: List<String>, val exp: Expression): Statement {
    override fun exec(env: Environment) {
        env.declareVarl(name, FunctionValue(args, exp, env.getTop()), false)
    }
}