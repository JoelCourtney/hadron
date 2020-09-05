package values

import errors.InvalidBinaryOperationError
import expressions.BinaryOperation
import org.jscience.mathematics.number.LargeInteger
import org.jscience.mathematics.number.Rational
import kotlin.math.pow

data class RationalValue(val v: Rational): NumericValue {
    constructor(n: Long, d: Long): this(Rational.valueOf(n, d))

    override fun add(with: Value): Value {
        return when(with) {
            is BooleanValue -> RationalValue(v + Rational.valueOf(with.v.toLong(),1)).downsize()
            is IntegerValue -> RationalValue(v + Rational.valueOf(with.v,LargeInteger.ONE)).downsize()
            is FloatValue -> FloatValue(v.toDouble() + with.v)
            is RationalValue -> RationalValue(v + with.v).downsize()
            is StringValue -> StringValue(toString() + with.v)
            else -> throw InvalidBinaryOperationError(BinaryOperation.ADD, this, with)
        }
    }

    override fun subtract(with: Value): Value {
        return when(with) {
            is BooleanValue -> RationalValue(v - Rational.valueOf(with.v.toLong(),1)).downsize()
            is IntegerValue -> RationalValue(v - Rational.valueOf(with.v,LargeInteger.ONE)).downsize()
            is FloatValue -> FloatValue(v.toDouble() - with.v)
            is RationalValue -> RationalValue(v - with.v).downsize()
            else -> throw InvalidBinaryOperationError(BinaryOperation.SUBTRACT, this, with)
        }
    }

    override fun multiply(with: Value): Value {
        return when(with) {
            is BooleanValue -> RationalValue(v * with.v.toLong()).downsize()
            is IntegerValue -> RationalValue(v * Rational.valueOf(with.v,LargeInteger.ONE)).downsize()
            is FloatValue -> FloatValue(v.toDouble() * with.v)
            is RationalValue -> RationalValue(v * with.v).downsize()
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u)
            else -> throw InvalidBinaryOperationError(BinaryOperation.MULTIPLY, this, with)
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> RationalValue(v.divide(Rational.valueOf(with.v.toLong(), 1))).downsize()
            is IntegerValue -> RationalValue(v.divide(Rational.valueOf(with.v, LargeInteger.ONE))).downsize()
            is FloatValue -> FloatValue(v.toDouble() / with.v)
            is RationalValue -> RationalValue(v.divide(with.v)).downsize()
            is UnitNumericValue -> UnitNumericValue(divide(with.n) as NumericValue, with.u.power(IntegerValue(-1)))
            else -> throw InvalidBinaryOperationError(BinaryOperation.DIVIDE, this, with)
        }
    }

    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> RationalValue(v.pow(with.v.toInt())).downsize()
            is IntegerValue -> {
                if (with.v == LargeInteger.ZERO) {
                    IntegerValue(LargeInteger.ONE)
                } else if (with.v > LargeInteger.ZERO) {
                    RationalValue(v.pow(with.v.toInt())).downsize()
                } else {
                    val exp = -with.v.toInt()
                    val rat = v.inverse()
                    RationalValue(rat.pow(exp)).downsize()
                }
            }
            is FloatValue -> FloatValue(v.toDouble().pow(with.v))
            is RationalValue -> FloatValue(v.toDouble().pow(with.v.toDouble()))
            else -> throw InvalidBinaryOperationError(BinaryOperation.EXPONENTIATE, this, with)
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when(with) {
            is BooleanValue -> BooleanValue(v.equals(with.v.toInt()))
            is IntegerValue -> BooleanValue(v.equals(with.v))
            is FloatValue -> BooleanValue(v.equals(with.v))
            is RationalValue -> BooleanValue(v == with.v)
            is StringValue -> BooleanValue(false)
            else -> throw InvalidBinaryOperationError(BinaryOperation.EQUAL, this, with)
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when(with) {
            is BooleanValue -> BooleanValue(!v.equals(with.v.toInt()))
            is IntegerValue -> BooleanValue(!v.equals(with.v))
            is FloatValue -> BooleanValue(!v.equals(with.v))
            is RationalValue -> BooleanValue(v != with.v)
            is StringValue -> BooleanValue(true)
            else -> throw InvalidBinaryOperationError(BinaryOperation.NOT_EQUAL, this, with)
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when(with) {
            is BooleanValue -> BooleanValue(v < Rational.valueOf(with.v.toLong(),1))
            is IntegerValue -> BooleanValue(v < Rational.valueOf(with.v, LargeInteger.ONE))
            is FloatValue -> BooleanValue(v.toDouble() < with.v)
            is RationalValue -> BooleanValue(v < with.v)
            else -> throw InvalidBinaryOperationError(BinaryOperation.LESS_THAN, this, with)
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when(with) {
            is BooleanValue -> BooleanValue(v > Rational.valueOf(with.v.toLong(),1))
            is IntegerValue -> BooleanValue(v > Rational.valueOf(with.v, LargeInteger.ONE))
            is FloatValue -> BooleanValue(v.toDouble() > with.v)
            is RationalValue -> BooleanValue(v > with.v)
            else -> throw InvalidBinaryOperationError(BinaryOperation.GREATER_THAN, this, with)
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when(with) {
            is BooleanValue -> BooleanValue(v <= Rational.valueOf(with.v.toLong(),1))
            is IntegerValue -> BooleanValue(v <= Rational.valueOf(with.v, LargeInteger.ONE))
            is FloatValue -> BooleanValue(v.toDouble() <= with.v)
            is RationalValue -> BooleanValue(v <= with.v)
            else -> throw InvalidBinaryOperationError(BinaryOperation.LESS_THAN_OR_EQUAL, this, with)
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when(with) {
            is BooleanValue -> BooleanValue(v >= Rational.valueOf(with.v.toLong(),1))
            is IntegerValue -> BooleanValue(v >= Rational.valueOf(with.v, LargeInteger.ONE))
            is FloatValue -> BooleanValue(v.toDouble() >= with.v)
            is RationalValue -> BooleanValue(v >= with.v)
            else -> throw InvalidBinaryOperationError(BinaryOperation.GREATER_THAN_OR_EQUAL, this, with)
        }
    }

    override fun negate(): Value {
        return RationalValue(v.opposite())
    }

    override fun toString(): String {
        return v.toString()
    }

    fun downsize(): Value {
        return if (v.divisor == LargeInteger.ONE) {
            IntegerValue(v.dividend.toLong())
        } else this
    }
}