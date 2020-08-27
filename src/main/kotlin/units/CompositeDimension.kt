package units

import values.NumericValue

data class CompositeDimension(
    override val components: Map<BaseDimension, NumericValue>
): Dimension