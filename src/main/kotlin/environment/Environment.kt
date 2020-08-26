package environment

import values.Value

data class Environment(val stack: MutableList<StackFrame> = mutableListOf()) {
    fun getVarl(name: String): Value {
        return stack.last().getVarl(name)
    }

    fun declareVarl(name: String, v: Value, mutable: Boolean) {
        stack.last().declareVarl(name, Varl(v, mutable))
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

    fun pop(): Value? {
        val result = stack.last().latestValue
        stack.removeAt(stack.size - 1)
        return result
    }

    fun getTop(): StackFrame {
        return stack.last()
    }
}