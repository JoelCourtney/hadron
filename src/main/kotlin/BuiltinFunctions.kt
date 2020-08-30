import values.Value
import values.VoidValue
import kotlin.reflect.KFunction

object BuiltinFunctions {
    fun lookup(s: String): BuiltinFunction? {
        if (s == "lookup") {
            TODO("make an error for this")
        }
        for (func in BuiltinFunctions::class.members) {
            if (func.name == s) {
                return BuiltinFunction(func as KFunction<*>)
            }
        }
        return null
    }

    fun println(args: List<Value>): Value {
        for (arg in args) {
            println(arg.toString())
        }
        return VoidValue
    }

    fun print(args: List<Value>): Value {
        for (arg in args) {
            print(arg)
        }
        return VoidValue
    }
}