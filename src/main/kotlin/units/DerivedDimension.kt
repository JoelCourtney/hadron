package units

data class DerivedDimension(val name: String, val dim: Dimension): Dimension by dim {
//    override fun toString(): String {
//        return name
//    }
}