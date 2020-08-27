package values

import units.Unit

data class UnitNumericValue(val n: NumericValue, val u: Unit): Value {
    fun convert(to: Unit): UnitNumericValue {
        val factor = u.convert(to)
        return UnitNumericValue(n.multiply(factor) as NumericValue, to)
    }

    override fun add(with: Value): Value {
        return when (with) {
            is StringValue -> StringValue("$this$with")
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                UnitNumericValue(newWith.n.add(n) as NumericValue, u)
            }
            else -> TODO("make an error for this")
        }
    }
}