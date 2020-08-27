package units

import values.IntegerValue
import values.NumericValue

data class BaseUnit(val name: String, override val dimension: BaseDimension): Unit {
    override val components: Map<Unit, NumericValue>
        get() = mapOf(this to IntegerValue(1))

    override fun toString(): String {
        return name
    }
}