package units

interface Dimension {
    fun decompose(): DerivedDimension
    fun isEquivalentTo(with: Dimension): Boolean
}