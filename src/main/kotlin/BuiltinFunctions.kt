import BuiltinFunctions.map
import values.*

/**
 * Contains and maps to the builtin functions written in Kotlin.
 *
 * @property map An immutable map of [String] function names to builtin functions.
 */
object BuiltinFunctions {
    private val map = mapOf(
            "println" to ::println,
            "print" to ::print,
            "sqrt" to ::sqrt,
            "asin" to ::asin,
            "ln" to ::ln,
            "log" to ::ln,
            "exp" to ::exp,
    )

    /**
     * Maps a [String] to a builtin function.
     *
     * Returns null if the function name is not found.
     *
     * @param s The [String] function name.
     * @return A function of signature ([List]<[Value]>)->[Value], or null if the function name is not found.
     */
    fun lookup(s: String): ((List<Value>)->Value)? {
        return map[s]
    }

    /**
     * Prints the argument to stdout with a trailing newline.
     *
     * @param args A [List] containing exactly one [Value].
     * @return [VoidValue]
     */
    private fun println(args: List<Value>): Value {
        for (arg in args) {
            println(arg.toString())
        }
        return VoidValue
    }

    /**
     * Prints the argument to stdout.
     *
     * @param args A [List] containing exactly one [Value].
     * @return [VoidValue]
     */
    private fun print(args: List<Value>): Value {
        for (arg in args) {
            print(arg)
        }
        return VoidValue
    }

    /**
     * Returns the arc sine of the argument.
     *
     * @param args A [List] containing exactly one [NumericValue] or [BooleanValue].
     * @return A [FloatValue] polymorphised as [Value], in radians.
     */
    private fun asin(args: List<Value>): Value {
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

    /**
     * Returns the square root of the argument.
     *
     * @param args A [List] containing exactly one [BooleanValue], [NumericValue], or [UnitNumericValue].
     * @return A [BooleanValue], [NumericValue], or [UnitNumericValue], polymorphised as [Value].
     */
    private fun sqrt(args: List<Value>): Value {
        if (args.size != 1) {
            TODO("make an error for this")
        }
        return when(val arg = args[0]) {
            is BooleanValue -> arg
            is IntegerValue -> FloatValue(kotlin.math.sqrt(arg.v.toDouble()))
            is FloatValue -> FloatValue(kotlin.math.sqrt(arg.v))
            is RationalValue -> FloatValue(kotlin.math.sqrt(arg.v.toDouble()))
            is UnitNumericValue -> UnitNumericValue(sqrt(listOf(arg.n)) as NumericValue, arg.u.power(RationalValue(1,2)))
            else -> TODO("make an error for this")
        }
    }

    /**
     * Returns the natural logarithm of the argument.
     *
     * @param args A [List] containing exactly one [BooleanValue] or [NumericValue].
     * @return A [FloatValue] polymorphised as [Value].
     */
    private fun ln(args: List<Value>): Value {
        if (args.size != 1) {
            TODO("make an error for this")
        }
        return when(val arg = args[0]) {
            is BooleanValue -> FloatValue(kotlin.math.ln(arg.v.toLong().toDouble()))
            is IntegerValue -> FloatValue(kotlin.math.ln(arg.v.toDouble()))
            is FloatValue -> FloatValue(kotlin.math.ln(arg.v))
            is RationalValue -> FloatValue(kotlin.math.ln(arg.v.toDouble()))
            else -> TODO("make an error for this")
        }
    }

    /**
     * Returns E to the power of the argument.
     *
     * @param args A [List] containing exactly one [BooleanValue] or [NumericValue]
     * @return A [FloatValue] polymorphised as [Value]
     */
    private fun exp(args: List<Value>): Value {
        if (args.size != 1) {
            TODO("make an error for this")
        }
        return when(val arg = args[0]) {
            is BooleanValue -> FloatValue(kotlin.math.exp(arg.v.toLong().toDouble()))
            is IntegerValue -> FloatValue(kotlin.math.exp(arg.v.toDouble()))
            is FloatValue -> FloatValue(kotlin.math.exp(arg.v))
            is RationalValue -> FloatValue(kotlin.math.exp(arg.v.toDouble()))
            else -> TODO("make an error for this")
        }
    }

//    fun format(args: List<Value>): Value {
//        if (args.size < 2) {
//            TODO("make an error for this")
//        }
//        val s = args[0].toString()
//        val sArgs: List<> = args.subList(1,args.size).map { it.toString() }
//    }
}