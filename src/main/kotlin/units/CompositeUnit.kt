package units

import values.CommonValues
import values.NumericValue

data class CompositeUnit(
    override val components: Map<Unit, NumericValue>
): Unit {
    override val dimension: Dimension
        get() = TODO("Not yet implemented")

    override fun toString(): String {
        var res = ""
        for ((k,v) in components) {
            res += if (!v.equal(CommonValues.one).v) {
                "$k^$v "
            } else {
                "$k "
            }
        }
        return res
    }
}