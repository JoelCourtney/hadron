package units

data class BaseDimension(val name: String): Dimension {
    override fun decompose(): DerivedDimension {
        return DerivedDimension(listOf(this), listOf())
    }

    override fun isEquivalentTo(with: Dimension): Boolean {
        return with is BaseDimension && with.name == name
    }
}