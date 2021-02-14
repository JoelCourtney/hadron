package values

import kotlin.math.pow

data class FloatValue(val v: Double): NumericValue {
    constructor(s: String): this(s.toDouble())

    override fun add(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v + with.v.toLong())
            is IntegerValue -> FloatValue(v + with.v.toDouble())
            is FloatValue -> FloatValue(v + with.v)
            is RationalValue -> FloatValue(v + with.v.toDouble())
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v - with.v.toLong())
            is IntegerValue -> FloatValue(v - with.v.toDouble())
            is FloatValue -> FloatValue(v - with.v)
            is RationalValue -> FloatValue(v - with.v.toDouble())
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v * with.v.toLong())
            is IntegerValue -> FloatValue(v * with.v.toDouble())
            is FloatValue -> FloatValue(v * with.v)
            is RationalValue -> FloatValue(v * with.v.toDouble())
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v / with.v.toLong())
            is IntegerValue -> FloatValue(v / with.v.toDouble())
            is FloatValue -> FloatValue(v / with.v)
            is RationalValue -> FloatValue(v / with.v.toDouble())
            is UnitNumericValue -> UnitNumericValue(divide(with.n) as NumericValue, with.u.power(IntegerValue(-1)))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v.pow(with.v.toInt()))
            is IntegerValue -> FloatValue(v.pow(with.v.toDouble()))
            is FloatValue -> FloatValue(v.pow(with.v))
            is RationalValue -> FloatValue(v.pow(with.v.toDouble()))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v.compareTo(with.v.toInt()) == 0)
            is IntegerValue -> BooleanValue(v.compareTo(with.v.toDouble()) == 0)
            is FloatValue -> BooleanValue(v == with.v)
            is RationalValue -> BooleanValue(v == with.v.toDouble())
            is StringValue -> BooleanValue(false)
            else -> TODO("make an error for this")
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v.compareTo(with.v.toInt()) != 0)
            is IntegerValue -> BooleanValue(v.compareTo(with.v.toDouble()) != 0)
            is FloatValue -> BooleanValue(v != with.v)
            is RationalValue -> BooleanValue(v != with.v.toDouble())
            is StringValue -> BooleanValue(true)
            else -> TODO("make an error for this")
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v < with.v.toInt())
            is IntegerValue -> BooleanValue(v < with.v.toDouble())
            is FloatValue -> BooleanValue(v < with.v)
            is RationalValue -> BooleanValue(v < with.v.toDouble())
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v > with.v.toInt())
            is IntegerValue -> BooleanValue(v > with.v.toDouble())
            is FloatValue -> BooleanValue(v > with.v)
            is RationalValue -> BooleanValue(v > with.v.toDouble())
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v <= with.v.toInt())
            is IntegerValue -> BooleanValue(v <= with.v.toDouble())
            is FloatValue -> BooleanValue(v <= with.v)
            is RationalValue -> BooleanValue(v <= with.v.toDouble())
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v >= with.v.toInt())
            is IntegerValue -> BooleanValue(v >= with.v.toDouble())
            is FloatValue -> BooleanValue(v >= with.v)
            is RationalValue -> BooleanValue(v >= with.v.toDouble())
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun negate(): Value {
        return FloatValue(-v)
    }

    override fun toString(): String {
        return v.toString()
    }
}