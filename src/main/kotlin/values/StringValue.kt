package values

import errors.InvalidBinaryOperationError

data class StringValue(val v: String): Value {
    override fun add(with: Value): Value {
        return StringValue(v + with.toString())
    }

    override fun equal(with: Value): BooleanValue {
        return when(with) {
            is StringValue -> BooleanValue(v == with.v)
            else -> BooleanValue(false)
        }
    }

    override fun toString(): String {
        return v
    }
}