package values

data class BooleanValue(val v: Boolean): Value {
    constructor(s: String): this(s.toLowerCase() == "true")

    override fun add(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() + with.v.toLong())
            is IntegerValue -> IntegerValue(v.toLong() + with.v)
            is FloatValue -> FloatValue(v.toInt() + with.v)
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() - with.v.toLong())
            is IntegerValue -> IntegerValue(v.toLong() - with.v)
            is FloatValue -> FloatValue(v.toInt() - with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() * with.v.toLong())
            is IntegerValue -> IntegerValue(v.toLong() * with.v)
            is FloatValue -> FloatValue(v.toInt() * with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.toLong() / with.v.toLong())
            is IntegerValue -> IntegerValue(v.toLong() / with.v)
            is FloatValue -> FloatValue(v.toInt() / with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> BooleanValue(if (with.v) v else true)
            is IntegerValue -> BooleanValue(v.toLong().pow(with.v) != 0L)
            is FloatValue -> BooleanValue(v.toLong().pow(with.v) != 0.0)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }
}

