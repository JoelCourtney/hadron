package units

import values.IntegerValue
import values.NumericValue

data class DerivedUnit(val name: String, val unit: CompositeUnit, val coefficient: NumericValue): Unit {
    override val components: Map<Unit, NumericValue>
        get() = mapOf(this to IntegerValue(1))

    override val dimension: Dimension
        get() = unit.dimension

    override fun toString(): String {
        return name
    }
}