import values.*

object BuiltinFunctions {
    val map = mapOf(
        "println" to ::println,
        "print" to ::print,
        "sqrt" to ::sqrt
    )
    fun lookup(s: String): BuiltinFunction? {
        val f = map[s]
        return if (f != null) {
            BuiltinFunction(f)
        } else {
            null
        }
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

    fun sqrt(args: List<Value>): Value {
        if (args.size != 1) {
            TODO("make an error for this")
        }
        val arg = args[0]
        return when(arg) {
            is BooleanValue -> arg
            is IntegerValue -> FloatValue(kotlin.math.sqrt(arg.v.toDouble()))
            is FloatValue -> FloatValue(kotlin.math.sqrt(arg.v))
            is UnitNumericValue -> UnitNumericValue(sqrt(listOf(arg.n)) as NumericValue, arg.u.power(FloatValue(0.5)))
            else -> TODO("make an error for this")
        }
    }
}