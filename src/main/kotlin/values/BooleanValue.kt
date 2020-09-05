package values

import org.jscience.mathematics.number.LargeInteger
import org.jscience.mathematics.number.Rational

data class BooleanValue(val v: Boolean): Value {
    constructor(s: String): this(s.toLowerCase() == "true")

    override fun add(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() + with.v.toLong())
            is IntegerValue -> IntegerValue(with.v + v.toLong())
            is FloatValue -> FloatValue(v.toInt() + with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v.toLong(), 1) + with.v).downsize()
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() - with.v.toLong())
            is IntegerValue -> IntegerValue(LargeInteger.valueOf(v.toLong()) - with.v)
            is FloatValue -> FloatValue(v.toInt() - with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v.toLong(), 1) - with.v).downsize()
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() * with.v.toLong())
            is IntegerValue -> IntegerValue(LargeInteger.valueOf(v.toLong()) * with.v)
            is FloatValue -> FloatValue(v.toInt() * with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v.toLong(), 1) * with.v).downsize()
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() / with.v.toLong())
            is IntegerValue -> RationalValue(Rational.valueOf(v.toLong(),1).divide(Rational.valueOf(with.v, LargeInteger.ONE))).downsize()
            is FloatValue -> FloatValue(v.toInt() / with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v.toLong(), 1).divide(with.v)).downsize()
            is UnitNumericValue -> UnitNumericValue(divide(with.n) as NumericValue, with.u.power(IntegerValue(-1)))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> BooleanValue(if (with.v) v else true)
            is IntegerValue -> IntegerValue(v.toLong().pow(with.v.toLong()))
            is FloatValue -> BooleanValue(v.toLong().pow(with.v) != 0.0)
            is RationalValue -> BooleanValue(v.toLong().pow(with.v.toDouble()) != 0.0)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v == with.v)
            is IntegerValue -> BooleanValue(LargeInteger.valueOf(v.toLong()) == with.v)
            is FloatValue -> BooleanValue(with.v == (if(v) 1.0 else 0.0))
            is RationalValue -> BooleanValue(with.v.equals(v.toLong()))
            is StringValue -> BooleanValue(false)
            else -> TODO("make an error for this")
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v != with.v)
            is IntegerValue -> BooleanValue(LargeInteger.valueOf(v.toLong()) != with.v)
            is FloatValue -> BooleanValue(with.v != (if(v) 1.0 else 0.0))
            is RationalValue -> BooleanValue(!with.v.equals(v.toLong()))
            is StringValue -> BooleanValue(true)
            else -> TODO("make an error for this")
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(!v && with.v)
            is IntegerValue -> BooleanValue(LargeInteger.valueOf(v.toLong()) < with.v)
            is FloatValue -> BooleanValue(v.toInt() < with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v.toLong(),1) < with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v && !with.v)
            is IntegerValue -> BooleanValue(LargeInteger.valueOf(v.toLong()) > with.v)
            is FloatValue -> BooleanValue(v.toInt() > with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v.toLong(),1) > with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(!v || with.v)
            is IntegerValue -> BooleanValue(LargeInteger.valueOf(v.toLong()) <= with.v)
            is FloatValue -> BooleanValue(v.toInt() <= with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v.toLong(),1) <= with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v || !with.v)
            is IntegerValue -> BooleanValue(LargeInteger.valueOf(v.toLong()) >= with.v)
            is FloatValue -> BooleanValue(v.toInt() >= with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v.toLong(),1) >= with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun negate(): Value {
        return if (v) IntegerValue(-1) else IntegerValue(0)
    }

    override fun toString(): String {
        return if (v) "true" else "false"
    }
}

