package units

import values.CommonValues
import values.IntegerValue
import values.NumericValue

interface Dimension {
    val components: Map<BaseDimension, NumericValue>

    infix fun multiply(with: Dimension): Dimension {
        val comps = components.toMutableMap()
        comps.absorb(with.components, CommonValues.one)
        return downsize(comps)
    }

    infix fun divide(with: Dimension): Dimension {
        val comps = components.toMutableMap()
        comps.absorb(with.components, IntegerValue(-1))
        return downsize(comps)
    }

    infix fun power(with: NumericValue): Dimension {
        val comps = components.toMutableMap()
        for ((k,v) in comps) {
            comps[k] = v.multiply(with) as NumericValue
        }
        return downsize(comps)
    }

    private fun downsize(comps: MutableMap<BaseDimension, NumericValue>): Dimension {
        val comps = comps.filterValues { !it.equal(CommonValues.zero).v }
        if (comps.size == 1) {
            val (key, value) = comps.asIterable().first()
            if (value.equal(CommonValues.one).v) {
                return key
            }
        }
        return CompositeDimension(comps)
    }

    fun isEquivalentTo(with: Dimension): Boolean {
        return components.entries == with.components.entries
    }
}