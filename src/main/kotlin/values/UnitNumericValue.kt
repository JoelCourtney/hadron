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

    override fun subtract(with: Value): Value {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                UnitNumericValue(newWith.n.subtract(n) as NumericValue, u)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when (with) {
            is BooleanValue,
            is IntegerValue,
            is FloatValue -> UnitNumericValue(n.multiply(with) as NumericValue, u)
            is UnitNumericValue -> UnitNumericValue(with.n.multiply(n) as NumericValue, u.multiply(with.u))
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when (with) {
            is BooleanValue,
            is IntegerValue,
            is FloatValue -> UnitNumericValue(n.divide(with) as NumericValue, u)
            is UnitNumericValue -> UnitNumericValue(with.n.divide(n) as NumericValue, u.divide(with.u))
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when (with) {
            is BooleanValue,
                is IntegerValue,
                is FloatValue -> UnitNumericValue(n.exponentiate(with) as NumericValue, u.power(with as NumericValue))
            else -> TODO("make an error for this")
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                BooleanValue(n.equal(newWith.n).v)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                BooleanValue(n.notEqual(newWith.n).v)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                BooleanValue(n.lessThan(newWith.n).v)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                BooleanValue(n.greaterThan(newWith.n).v)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                BooleanValue(n.lessThanOrEqual(newWith.n).v)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                BooleanValue(n.greaterThanOrEqual(newWith.n).v)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun negate(): UnitNumericValue {
        return UnitNumericValue(n.negate() as NumericValue, u)
    }

    override fun toString(): String {
        return "$n[$u]"
    }
}