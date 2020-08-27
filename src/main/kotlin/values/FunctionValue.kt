package values

import environment.StackFrame
import expressions.Expression

data class FunctionValue(val args: List<String>, val exp: Expression, val deferTo: StackFrame): Value {
    override fun toString(): String {
        return "FunctionValue(args=$args, exp=$exp)"
    }
}