package values

import org.jscience.mathematics.number.LargeInteger
import org.jscience.mathematics.number.Rational
import kotlin.math.pow

data class IntegerValue(val v: LargeInteger): NumericValue {
    constructor(s: String): this(LargeInteger.valueOf(s))
    constructor(i: Long): this(LargeInteger.valueOf(i))

    override fun add(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v + with.v.toLong())
            is IntegerValue -> IntegerValue(v + with.v)
            is FloatValue -> FloatValue(v.toDouble() + with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v, LargeInteger.ONE) + with.v)
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v - with.v.toLong())
            is IntegerValue -> IntegerValue(v - with.v)
            is FloatValue -> FloatValue(v.toDouble() - with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v,LargeInteger.ONE) - with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v * with.v.toLong())
            is IntegerValue -> IntegerValue(v * with.v)
            is FloatValue -> FloatValue(v.toDouble() * with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v,LargeInteger.ONE) * with.v)
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.divide(with.v.toInt()))
            is IntegerValue -> RationalValue(Rational.valueOf(v, with.v))
            is FloatValue -> FloatValue(v.toDouble() / with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v, LargeInteger.ONE).divide(with.v))
            is UnitNumericValue -> UnitNumericValue(divide(with.n) as NumericValue, with.u.power(IntegerValue(-1)))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    // TODO("make exponentiate return RATIONALS when we implement them")
    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(if (with.v) v else LargeInteger.ONE)
            is IntegerValue -> {
                if (with.v == LargeInteger.ZERO) {
                    IntegerValue(LargeInteger.ONE)
                } else if (with.v > LargeInteger.ZERO) {
                    IntegerValue(v.pow(with.v.toInt()))
                } else {
                    val exp = with.v.opposite().toInt()
                    RationalValue(Rational.valueOf(LargeInteger.ONE, v).pow(exp)).downsize()
                }
            }
            is FloatValue -> FloatValue(v.toDouble().pow(with.v))
            is RationalValue -> FloatValue(v.toDouble().pow(with.v.toDouble()))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v.equals(with.v.toLong()))
            is IntegerValue -> BooleanValue(v == with.v)
            is FloatValue -> BooleanValue(v.toDouble() == with.v)
            is RationalValue -> BooleanValue(with.v.equals(v))
            else -> BooleanValue(false)
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(!v.equals(with.v.toLong()))
            is IntegerValue -> BooleanValue(v != with.v)
            is FloatValue -> BooleanValue(v.toDouble() != with.v)
            is RationalValue -> BooleanValue(!with.v.equals(v))
            else -> BooleanValue(true)
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v < with.v.toLong())
            is IntegerValue -> BooleanValue(v < with.v)
            is FloatValue -> BooleanValue(v.toDouble() < with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) < with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v > with.v.toLong())
            is IntegerValue -> BooleanValue(v > with.v)
            is FloatValue -> BooleanValue(v.toDouble() > with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) > with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v <= with.v.toLong())
            is IntegerValue -> BooleanValue(v <= with.v)
            is FloatValue -> BooleanValue(v.toDouble() <= with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) <= with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v >= with.v.toLong())
            is IntegerValue -> BooleanValue(v >= with.v)
            is FloatValue -> BooleanValue(v.toDouble() >= with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) >= with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun negate(): Value {
        return IntegerValue(v.opposite())
    }

    override fun toString(): String {
        return v.toString()
    }
}
