package units

import java.awt.Dimension

data class BaseUnit(val name: String, override val dimension: BaseDimension): Unit {
    override fun decompose(): UnitFraction {
        return Pair(listOf(this), listOf())
    }

    override fun reduce(): Pair<Unit, Double> {
        return Pair(this, 1.0)
    }
}