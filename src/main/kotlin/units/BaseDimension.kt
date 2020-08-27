package units

import values.IntegerValue
import values.NumericValue

data class BaseDimension(val name: String): Dimension {
    override val components: Map<BaseDimension, NumericValue>
        get() = mapOf(this to IntegerValue(1))
}