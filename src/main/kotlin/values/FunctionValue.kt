package values

import environment.StackFrame
import expressions.Expression

data class FunctionValue(val args: List<String>, val exp: Expression, val deferTo: StackFrame): Value {
    override fun add(with: Value): Value {
        TODO("make an error for this")
    }

    override fun subtract(with: Value): Value {
        TODO("make an error for this")
    }

    override fun multiply(with: Value): Value {
        TODO("make an error for this")
    }

    override fun divide(with: Value): Value {
        TODO("make an error for this")
    }

    override fun exponentiate(with: Value): Value {
        TODO("make an error for this")
    }

    override fun lessThan(with: Value): Value {
        TODO("make an error for this")
    }

    override fun greaterThan(with: Value): Value {
        TODO("make an error for this")
    }

    override fun lessThanOrEqual(with: Value): Value {
        TODO("make an error for this")
    }

    override fun greaterThanOrEqual(with: Value): Value {
        TODO("make an error for this")
    }

    override fun negate(): Value {
        TODO("make an error for this")
    }

    override fun toString(): String {
        return "FunctionValue(args=$args, exp=$exp)"
    }
}