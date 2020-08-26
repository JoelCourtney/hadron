package expressions

import environment.Environment
import environment.StackFrame
import statements.Statement
import values.Value

data class BlockExpression(val statements: List<Statement>): Expression {
    override fun eval(env: Environment): Value {
        env.push(StackFrame(env.getTop()))
        for (statement in statements) {
            statement.exec(env)
        }
        return env.pop()
    }
}