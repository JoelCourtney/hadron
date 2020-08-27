package units

import values.CommonValues
import values.IntegerValue
import values.NumericValue

data class DerivedUnit(val name: String, val unit: CompositeUnit, val coefficient: NumericValue): Unit {
    override val components: Map<Unit, NumericValue>
        get() = mapOf(this to CommonValues.one)

    override val dimension: Dimension
        get() = unit.dimension

    override fun fullReduce(): Pair<Map<BaseUnit, NumericValue>,  NumericValue> {
        val (comps, factor) = unit.fullReduce()
        return comps to factor.multiply(coefficient) as NumericValue
    }

//    override fun toString(): String {
//        return name
//    }
}