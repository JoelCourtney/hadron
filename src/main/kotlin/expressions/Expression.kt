package expressions

import environment.Environment
import values.Value

/**
 * A portion of the parse tree than evaluates to a [Value].
 */
interface Expression {
    /**
     * Evaluate the expression to a [Value].
     *
     * @param[env] The environment is used to look up variables, units, etc. The environment should not be modified except in a [BlockExpression].
     *
     * @return The [Value] that the expression evaluates to.
     */
    fun eval(env: Environment): Value
}