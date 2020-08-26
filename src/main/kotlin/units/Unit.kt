package units

interface Unit {
    val dimension: Dimension

    fun decompose(): UnitFraction
    fun reduce(): Pair<Unit, Double>

    fun isEquivalentTo(with: Unit): Boolean {
        return dimension.isEquivalentTo(with.dimension)
    }
}

typealias UnitFraction = Pair<List<BaseUnit>, List<BaseUnit>>