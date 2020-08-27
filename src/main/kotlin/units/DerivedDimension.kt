package units

data class DerivedDimension(val name: String, val dim: CompositeDimension): Dimension by dim {
    override fun toString(): String {
        return name
    }
}