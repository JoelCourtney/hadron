package values

import kotlin.math.pow

data class FloatValue(val v: Double): NumericValue {
    constructor(s: String): this(s.toDouble())

    override fun add(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v + with.v.toLong())
            is IntegerValue -> FloatValue(v + with.v)
            is FloatValue -> FloatValue(v + with.v)
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v - with.v.toLong())
            is IntegerValue -> FloatValue(v - with.v)
            is FloatValue -> FloatValue(v - with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v * with.v.toLong())
            is IntegerValue -> FloatValue(v * with.v)
            is FloatValue -> FloatValue(v * with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v / with.v.toLong())
            is IntegerValue -> FloatValue(v / with.v)
            is FloatValue -> FloatValue(v / with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when (with) {
            is BooleanValue -> FloatValue(v.pow(with.v.toInt()))
            is IntegerValue -> FloatValue(v.pow(with.v.toInt()))
            is FloatValue -> FloatValue(v.pow(with.v))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun lessThan(with: Value): Value {
        return when (with) {
            is BooleanValue -> BooleanValue(v < with.v.toInt())
            is IntegerValue -> BooleanValue(v < with.v)
            is FloatValue -> BooleanValue(v < with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): Value {
        return when (with) {
            is BooleanValue -> BooleanValue(v > with.v.toInt())
            is IntegerValue -> BooleanValue(v > with.v)
            is FloatValue -> BooleanValue(v > with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): Value {
        return when (with) {
            is BooleanValue -> BooleanValue(v <= with.v.toInt())
            is IntegerValue -> BooleanValue(v <= with.v)
            is FloatValue -> BooleanValue(v <= with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): Value {
        return when (with) {
            is BooleanValue -> BooleanValue(v >= with.v.toInt())
            is IntegerValue -> BooleanValue(v >=with.v)
            is FloatValue -> BooleanValue(v >= with.v)
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