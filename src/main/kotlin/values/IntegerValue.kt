package values

import kotlin.math.pow

data class IntegerValue(val v: Long): Value {
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
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v / with.v.toLong())
            is IntegerValue -> IntegerValue(v / with.v)
            is FloatValue -> FloatValue(v / with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(if (with.v) v else 1)
            is IntegerValue -> IntegerValue(v.pow(with.v))
            is FloatValue -> FloatValue(v.pow(with.v))
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
