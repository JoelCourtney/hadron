import org.jscience.mathematics.number.Rational
import values.*

object BuiltinFunctions {
    val map = mapOf(
        "println" to ::println,
        "print" to ::print,
        "sqrt" to ::sqrt,
        "asin" to ::asin
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

    fun asin(args: List<Value>): Value {
        if (args.size != 1) {
            TODO("make an error for this")
        }
        return when(val arg = args[0]) {
            is BooleanValue -> FloatValue(kotlin.math.asin(arg.v.toLong().toDouble()))
            is IntegerValue -> FloatValue(kotlin.math.asin(arg.v.toDouble()))
            is FloatValue -> FloatValue(kotlin.math.asin(arg.v))
            is RationalValue -> FloatValue(kotlin.math.asin(arg.v.toDouble()))
            else -> TODO("make an error for this")
        }
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
            is RationalValue -> FloatValue(kotlin.math.sqrt(arg.v.toDouble()))
            is UnitNumericValue -> UnitNumericValue(sqrt(listOf(arg.n)) as NumericValue, arg.u.power(RationalValue(1,2)))
            else -> TODO("make an error for this")
        }
    }
}