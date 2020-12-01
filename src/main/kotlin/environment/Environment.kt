package environment

import values.Value
import units.Unit
import units.Dimension
import units.UnitPrefix

/**
 * The environment that Hadron statements refer to and execute in.
 *
 * Delegates most operations except for [push] and [pop] to the top [StackFrame] in the stack.
 *
 * @property stack The list of stack frames in the current execution state of the Hadron script.
 */
data class Environment(val stack: MutableList<StackFrame> = mutableListOf()) {
    fun getVarl(name: String): Value {
        return stack.last().getVarl(name)
    }

    fun getUnit(name: String): Unit {
        return stack.last().getUnit(name)
    }

    fun getUnitPrefix(name: String): UnitPrefix {
        return stack.last().getUnitPrefix(name)
    }

    fun getDimension(name: String): Dimension {
        return stack.last().getDimension(name)
    }

    fun declareVarl(name: String, v: Value, mutable: Boolean) {
        stack.last().declareVarl(name, Varl(v, mutable))
    }

    fun declareUnit(name: String, u: Unit) {
        stack.last().declareUnit(name, u)
    }

    fun declareUnitPrefix(name: String, p: UnitPrefix) {
        stack.last().declareUnitPrefix(name, p)
    }

    fun declareDimension(name: String, d: Dimension) {
        stack.last().declareDimension(name, d)
    }

    fun assignVarl(name: String, v: Value) {
        stack.last().assignVarl(name, v)
    }

    fun stateValue(v: Value) {
        stack.last().latestValue = v
    }

    fun push(frame: StackFrame) {
        stack.add(frame)
    }

    fun pop(): Value {
        val result = stack.last().latestValue
        stack.removeAt(stack.size - 1)
        return result
    }

    fun getTop(): StackFrame {
        return stack.last()
    }

    fun absorbFrame(f: StackFrame) {
        stack.last().absorb(f)
    }
}