package values

import org.jscience.mathematics.number.LargeInteger
import org.jscience.mathematics.number.Rational
import java.math.BigInteger
import java.util.*
import kotlin.math.pow


data class IntegerValue(val v: LargeInteger): NumericValue {
    constructor(s: String): this(LargeInteger.valueOf(s))
    constructor(i: Long): this(LargeInteger.valueOf(i))

    override fun add(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v + with.v.toLong())
            is IntegerValue -> IntegerValue(v + with.v)
            is FloatValue -> FloatValue(v.toDouble() + with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v, LargeInteger.ONE) + with.v)
            is StringValue -> StringValue(v.toString() + with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun subtract(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v - with.v.toLong())
            is IntegerValue -> IntegerValue(v - with.v)
            is FloatValue -> FloatValue(v.toDouble() - with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v, LargeInteger.ONE) - with.v)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun multiply(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v * with.v.toLong())
            is IntegerValue -> IntegerValue(v * with.v)
            is FloatValue -> FloatValue(v.toDouble() * with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v, LargeInteger.ONE) * with.v)
            is UnitNumericValue -> UnitNumericValue(multiply(with.n) as NumericValue, with.u)
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun divide(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(v.divide(with.v.toInt()))
            is IntegerValue -> RationalValue(Rational.valueOf(v, with.v)).downsize()
            is FloatValue -> FloatValue(v.toDouble() / with.v)
            is RationalValue -> RationalValue(Rational.valueOf(v, LargeInteger.ONE).divide(with.v))
            is UnitNumericValue -> UnitNumericValue(divide(with.n) as NumericValue, with.u.power(IntegerValue(-1)))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    // TODO("make exponentiate return RATIONALS when we implement them")
    override fun exponentiate(with: Value): Value {
        return when(with) {
            is BooleanValue -> IntegerValue(if (with.v) v else LargeInteger.ONE)
            is IntegerValue -> {
                if (with.v == LargeInteger.ZERO) {
                    IntegerValue(LargeInteger.ONE)
                } else if (with.v > LargeInteger.ZERO) {
                    IntegerValue(v.pow(with.v.toInt()))
                } else {
                    val exp = with.v.opposite().toInt()
                    RationalValue(Rational.valueOf(LargeInteger.ONE, v).pow(exp)).downsize()
                }
            }
            is FloatValue -> FloatValue(v.toDouble().pow(with.v))
            is RationalValue -> FloatValue(v.toDouble().pow(with.v.toDouble()))
            is StringValue -> TODO("make an error for this")
            else -> TODO("make an error for this")
        }
    }

    override fun equal(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v.equals(with.v.toLong()))
            is IntegerValue -> BooleanValue(v == with.v)
            is FloatValue -> BooleanValue(v.toDouble() == with.v)
            is RationalValue -> BooleanValue(with.v.equals(v))
            else -> BooleanValue(false)
        }
    }

    override fun notEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(!v.equals(with.v.toLong()))
            is IntegerValue -> BooleanValue(v != with.v)
            is FloatValue -> BooleanValue(v.toDouble() != with.v)
            is RationalValue -> BooleanValue(!with.v.equals(v))
            else -> BooleanValue(true)
        }
    }

    override fun lessThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v < with.v.toLong())
            is IntegerValue -> BooleanValue(v < with.v)
            is FloatValue -> BooleanValue(v.toDouble() < with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) < with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThan(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v > with.v.toLong())
            is IntegerValue -> BooleanValue(v > with.v)
            is FloatValue -> BooleanValue(v.toDouble() > with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) > with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun lessThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v <= with.v.toLong())
            is IntegerValue -> BooleanValue(v <= with.v)
            is FloatValue -> BooleanValue(v.toDouble() <= with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) <= with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun greaterThanOrEqual(with: Value): BooleanValue {
        return when (with) {
            is BooleanValue -> BooleanValue(v >= with.v.toLong())
            is IntegerValue -> BooleanValue(v >= with.v)
            is FloatValue -> BooleanValue(v.toDouble() >= with.v)
            is RationalValue -> BooleanValue(Rational.valueOf(v, LargeInteger.ONE) >= with.v)
            else -> TODO("make an error for this")
        }
    }

    override fun negate(): Value {
        return IntegerValue(v.opposite())
    }

    override fun toString(): String {
        return v.toString()
    }

    fun factorial(): IntegerValue {
        if (v.isNegative) {
            TODO("make an error for this")
        }
        if (v.bitLength() > java.lang.Long.SIZE) {
            TODO("make an error for this")
        }

        val n: Long = v.toLong()

        // If the factorial is small enough, just use LongMath to do it.
        if (n < factorials.size) {
            return IntegerValue(factorials[n.toInt()])
        }

        // Pre-allocate space for our list of intermediate BigIntegers.

        // Pre-allocate space for our list of intermediate BigIntegers.
        val approxSize: Int = (n*kotlin.math.log2(n.toDouble()) / java.lang.Long.SIZE).toInt() + 1
        val bigNums = ArrayList<BigInteger>(approxSize)

        // Start from the pre-computed maximum long factorial.

        // Start from the pre-computed maximum long factorial.
        val startingNumber: Int = factorials.size
        var product: Long = factorials[startingNumber - 1]
        // Strip off 2s from this value.
        // Strip off 2s from this value.
        var shift = java.lang.Long.numberOfTrailingZeros(product)
        product = product shr shift

        // Use floor(log2(num)) + 1 to prevent overflow of multiplication.

        // Use floor(log2(num)) + 1 to prevent overflow of multiplication.
        var productBits: Int = java.lang.Long.SIZE - java.lang.Long.numberOfLeadingZeros(product) + 1
        var bits: Int = Integer.SIZE - Integer.numberOfLeadingZeros(startingNumber) + 1
        // Check for the next power of two boundary, to save us a CLZ operation.
        // Check for the next power of two boundary, to save us a CLZ operation.
        var nextPowerOfTwo = 1 shl bits - 1

        // Iteratively multiply the longs as big as they can go.

        // Iteratively multiply the longs as big as they can go.
        for (num in startingNumber..n) {
            // Check to see if the floor(log2(num)) + 1 has changed.
            if (num and nextPowerOfTwo.toLong() != 0L) {
                nextPowerOfTwo = nextPowerOfTwo shl 1
                bits++
            }
            // Get rid of the 2s in num.
            val tz = java.lang.Long.numberOfTrailingZeros(num)
            val normalizedNum = (num shr tz)
            shift += tz
            // Adjust floor(log2(num)) + 1.
            val normalizedBits = bits - tz
            // If it won't fit in a long, then we store off the intermediate product.
            if (normalizedBits + productBits >= java.lang.Long.SIZE) {
                bigNums.add(BigInteger.valueOf(product))
                product = 1
            }
            product *= normalizedNum
            productBits = java.lang.Long.SIZE - java.lang.Long.numberOfLeadingZeros(product) + 1
        }
        // Check for leftovers.
        // Check for leftovers.
        if (product > 1) {
            bigNums.add(BigInteger.valueOf(product))
        }
        // Efficiently multiply all the intermediate products together.
        // Efficiently multiply all the intermediate products together.
        return IntegerValue(listProduct(bigNums).shiftLeft(shift))
    }

    companion object {
        val factorials = longArrayOf(
            1L,
            1L,
            1L * 2,
            1L * 2 * 3,
            1L * 2 * 3 * 4,
            1L * 2 * 3 * 4 * 5,
            1L * 2 * 3 * 4 * 5 * 6,
            1L * 2 * 3 * 4 * 5 * 6 * 7,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19,
            1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19 * 20
        )

        private fun listProduct(nums: List<BigInteger>): LargeInteger {
            return LargeInteger.valueOf(listProduct(nums, 0, nums.size))
        }

        private fun listProduct(nums: List<BigInteger>, start: Int, end: Int): BigInteger {
            return when (end - start) {
                0 -> BigInteger.ONE
                1 -> nums[start]
                2 -> nums[start].multiply(nums[start + 1])
                3 -> nums[start].multiply(nums[start + 1]).multiply(nums[start + 2])
                else -> {
                    // Otherwise, split the list in half and recursively do this.
                    val m = end + start ushr 1
                    listProduct(nums, start, m).multiply(listProduct(nums, m, end))
                }
            }
        }
    }
}