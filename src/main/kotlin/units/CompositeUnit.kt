package units

import values.CommonValues
import values.NumericValue

data class CompositeUnit(
    override val components: Map<Unit, NumericValue>
): Unit {
    override val dimension: Dimension
        get() {
            var result: Dimension? = null
            for ((u, p) in components) {
                result = if (result == null) {
                    u.dimension power p
                } else {
                    result multiply (u.dimension power p)
                }
            }
            return result ?: TODO("make an error for this")
        }

    override fun fullReduce(): Pair<Map<BaseUnit, NumericValue>, NumericValue> {
        val newMap = mutableMapOf<BaseUnit, NumericValue>()
        var factor: NumericValue = CommonValues.one
        for ((u, p) in components) {
            val (comps, fac) = u.fullReduce()
            newMap.absorb(comps, p)
            factor = factor.multiply(fac.exponentiate(p)) as NumericValue
        }
        return newMap to factor
    }

    override fun toString(): String {
        var res = ""
        for ((k,v) in components) {
            res += if (!v.equal(CommonValues.one).v) {
                "$k^$v "
            } else {
                "$k "
            }
        }
        return if (res.last() == ' ') {
            res.substring(0..res.length-2)
        } else res
    }
}