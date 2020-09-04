package expressions

import environment.Environment
import environment.StackFrame
import statements.Statement
import statements.ValueStatement
import values.Value

/**
 * A block of [Statements][Statement] enclosed in curly braces.
 *
 * A new [StackFrame] is pushed onto the [Environment], then the [Statements][Statement] are executed sequentially. The resulting value is the value of the last [ValueStatement] in the block. The [StackFrame] is then popped off.
 *
 * @property[statements] The list of [Statements][Statement] inside this block.
 */
data class BlockExpression(val statements: List<Statement>): Expression {
    override fun eval(env: Environment): Value {
        env.push(StackFrame(env.getTop()))
        for (statement in statements) {
            statement.exec(env)
        }
        return env.pop()
    }
}