package values

data class StringValue(val v: String): Value {
    override fun add(with: Value): Value {
        return StringValue(v + with.toString())
    }

    override fun subtract(with: Value): Value {
        TODO("make an error for this")
    }

    override fun multiply(with: Value): Value {
        TODO("make an error for this")
    }

    override fun divide(with: Value): Value {
        TODO("make an error for this")
    }

    override fun exponentiate(with: Value): Value {
        TODO("make an error for this")
    }
}