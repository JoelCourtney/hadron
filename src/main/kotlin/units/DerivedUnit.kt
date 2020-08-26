package units

import values.NumericValue

data class DerivedUnit(
    val name: String?,
	val coefficient: NumericValue,
	val shift: NumericValue,
	val numerator: List<Unit>,
	val denominator: List<Unit>
): Unit {
    override val dimension: Dimension
        get() = TODO("Not yet implemented")

    override fun decompose(): UnitFraction {
        val num: MutableList<BaseUnit> = mutableListOf()
        val den: MutableList<BaseUnit> = mutableListOf()
    }

    override fun reduce(): Pair<Unit, Double> {
        TODO("Not yet implemented")
    }
}