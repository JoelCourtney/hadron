package units

data class DerivedDimension(val name: String?, val numerator: List<BaseDimension>, val denominator: List<BaseDimension>): Dimension {
    override fun decompose(): DerivedDimension {
        return this
    }

    override fun isEquivalentTo(with: Dimension): Boolean {
        TODO("Not yet implemented")
    }
}