package values

import units.EmptyUnit
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
                UnitNumericValue(n.add(newWith.n) as NumericValue, u)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when (with) {
            is UnitNumericValue -> {
                val newWith = with.convert(u)
                UnitNumericValue(n.subtract(newWith.n) as NumericValue, u)
            }
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when (with) {
            is BooleanValue,
            is IntegerValue,
            is FloatValue,
            is RationalValue -> UnitNumericValue(n.multiply(with) as NumericValue, u)
            is UnitNumericValue -> {
                val newU = u.multiply(with.u)
                if (newU != EmptyUnit) {
                    UnitNumericValue(n.multiply(with.n) as NumericValue, newU).checkEmpty()
                } else {
                    n.multiply(with.n)
                }
            }
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when (with) {
            is BooleanValue,
            is IntegerValue,
            is FloatValue,
            is RationalValue -> UnitNumericValue(n.divide(with) as NumericValue, u)
            is UnitNumericValue -> {
                val newU = u.divide(with.u)
                if (newU != EmptyUnit) {
                    UnitNumericValue(n.divide(with.n) as NumericValue, newU).checkEmpty()
                } else {
                    n.divide(with.n)
                }
            }
            else -> TODO("make an error for this")
        }
    }

    override fun exponentiate(with: Value): Value {
        return when (with) {
            is BooleanValue,
            is IntegerValue,
            is FloatValue,
            is RationalValue -> UnitNumericValue(n.exponentiate(with) as NumericValue, u.power(with as NumericValue))
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

    private fun checkEmpty(): Value {
        return if (u.isEquivalentTo(EmptyUnit)) {
            val fac = u.convert(EmptyUnit)
            n.multiply(fac)
        } else {
            this
        }
    }
}