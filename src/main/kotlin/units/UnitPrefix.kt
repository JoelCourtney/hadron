package units

import values.NumericValue

/**
 * A collection of prefixes associated with constant multipliers to be applied to base [Unit]s.
 *
 * The most important example is SI units prefixes, such as k (1000), c (0.01), M (10^6), etc. Declaring grams (for example) and all of its variations would be tedious and error-prone, so prefixes can be applied using the syntax `unit g prefix SI`, assuming the SI prefix has already been declared.
 *
 * @property prefixes The [Map] of prefix [String]s to constant multiplier [NumericValue]s to be applied to the base [Unit].
 */
data class UnitPrefix(val prefixes: Map<String, NumericValue>){
}