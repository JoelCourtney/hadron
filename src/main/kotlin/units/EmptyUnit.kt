package units

import values.CommonValues
import values.NumericValue

object EmptyUnit: Unit {
    override val dimension: Dimension
        get() = EmptyDimension
    override val components: Map<Unit, NumericValue>
        get() = mapOf()

    override fun fullReduce(): Pair<Map<BaseUnit, NumericValue>, NumericValue> {
        return mapOf<BaseUnit, NumericValue>() to CommonValues.one
    }

}