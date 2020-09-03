package units

import values.NumericValue

object EmptyDimension: Dimension {
    override val components: Map<BaseDimension, NumericValue>
        get() = mapOf()

}