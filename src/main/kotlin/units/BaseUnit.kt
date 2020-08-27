package units

import values.CommonValues
import values.IntegerValue
import values.NumericValue

data class BaseUnit(val name: String, override val dimension: BaseDimension): Unit {
    override val components: Map<Unit, NumericValue>
        get() = mapOf(this to CommonValues.one)

    override fun fullReduce(): Pair<Map<BaseUnit, NumericValue>, NumericValue> {
        return mapOf(this to CommonValues.one) to CommonValues.one
    }

//    override fun toString(): String {
//        return name
//    }
}