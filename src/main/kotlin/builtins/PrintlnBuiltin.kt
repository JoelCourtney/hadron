package builtins

import values.Value
import values.VoidValue

object PrintlnBuiltin: BuiltinFunction {
    override fun exec(args: List<Value>): Value {
        for (arg in args) {
            println(arg.toString())
        }
        return VoidValue
    }
}