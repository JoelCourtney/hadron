package units

import values.CommonValues
import values.IntegerValue
import values.NumericValue

interface Unit {
    val dimension: Dimension
    val components: Map<Unit, NumericValue>

    infix fun multiply(with: Unit): Unit {
        val comps = components.toMutableMap()
        comps.absorb(with.components, CommonValues.one)
        return downsize(comps)
    }

    infix fun divide(with: Unit): Unit {
        val comps = components.toMutableMap()
        comps.absorb(with.components, IntegerValue(-1))
        return downsize(comps)
    }

    infix fun power(with: NumericValue): Unit {
        val comps = components.toMutableMap()
        for ((k,v) in comps) {
            comps[k] = v.multiply(with) as NumericValue
        }
        return downsize(comps)
    }

    private fun downsize(comps: MutableMap<Unit, NumericValue>): Unit {
        val components = comps.filterValues { !it.equal(CommonValues.zero).v }
        if (components.size == 1) {
            val (key, value) = components.asIterable().first()
            if (value.equal(CommonValues.one).v) {
                return key
            }
        } else if (components.isEmpty()) {
            return EmptyUnit
        }
        return CompositeUnit(components)
    }

    fun isEquivalentTo(with: Unit): Boolean {
        return dimension.isEquivalentTo(with.dimension)
    }

    fun convert(to: Unit): NumericValue {
        if (dimension.isEquivalentTo(to.dimension)) {
            val cancel = this divide to
            val (_, factor) = cancel.fullReduce()
            return factor
        } else {
            TODO("make an error for this")
        }
    }

    // Fully decomposes to base units, and returns the factor of the conversion
    fun fullReduce(): Pair<Map<BaseUnit, NumericValue>, NumericValue>
}

fun<T> MutableMap<T, NumericValue>.absorb(with: Map<T, NumericValue>, n: NumericValue) {
    for ((k,v) in with) {
        this[k] = this.getOrDefault(k, IntegerValue(0)).add(v.multiply(n)) as NumericValue
    }
}