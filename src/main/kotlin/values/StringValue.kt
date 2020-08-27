package values

data class StringValue(val v: String): Value {
    override fun add(with: Value): Value {
        return StringValue(v + with.toString())
    }

    override fun toString(): String {
        return v
    }
}