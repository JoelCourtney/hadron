package values

import kotlin.math.pow

data class IntegerValue(val v: Long): NumericValue {
    constructor(s: String): this(s.toLong())

    override fun add(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v + with.v.toLong())
            is IntegerValue -> IntegerValue(v + with.v)
            is FloatValue -> FloatValue(v + with.v)
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v - with.v.toLong())
            is IntegerValue -> IntegerValue(v - with.v)
            is FloatValue -> FloatValue(v - with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v * with.v.toLong())
            is IntegerValue -> IntegerValue(v * with.v)
            is FloatValue -> FloatValue(v * with.v)
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v / with.v.toLong())
            is IntegerValue -> FloatValue(v.toDouble() / with.v)
            is FloatValue -> FloatValue(v / with.v)
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u.power(IntegerValue(-1)))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    // TODO("make exponentiate return RATIONALS when we implement them")
    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(if (with.v) v else 1)
            is IntegerValue -> if (with.v >= 0) IntegerValue(v.pow(with.v)) else FloatValue(v.toDouble().pow(with.v.toInt()))
            is FloatValue -> FloatValue(v.pow(with.v))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v == with.v.toLong())
            is IntegerValue -> BooleanValue(v == with.v)
            is FloatValue -> BooleanValue(v.compareTo(with.v) == 0)
            is StringValue -> BooleanValue(false)
            else -> TODO("make an error for this")
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v != with.v.toLong())
            is IntegerValue -> BooleanValue(v != with.v)
            is FloatValue -> BooleanValue(v.compareTo(with.v) != 0)
            is StringValue -> BooleanValue(true)
            else -> TODO("make an error for this")
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v < with.v.toInt())
            is IntegerValue -> BooleanValue(v < with.v)
            is FloatValue -> BooleanValue(v < with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v > with.v.toInt())
            is IntegerValue -> BooleanValue(v > with.v)
            is FloatValue -> BooleanValue(v > with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v <= with.v.toInt())
            is IntegerValue -> BooleanValue(v <= with.v)
            is FloatValue -> BooleanValue(v <= with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v >= with.v.toInt())
            is IntegerValue -> BooleanValue(v >= with.v)
            is FloatValue -> BooleanValue(v >= with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun negate(): Value {
        return IntegerValue(-v)
    }

    override fun toString(): String {
        return v.toString()
    }
}
