package builtins

import values.Value

interface BuiltinFunction {
    fun exec(args: List<Value>): Value
}