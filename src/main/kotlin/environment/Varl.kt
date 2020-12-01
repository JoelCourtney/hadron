package environment

import values.Value

/**
 * Contains a variable or value.
 *
 * Note there are two uses of the word "Value": values in the interpreter are the data used for calculations, and have no inherent concept of mutability. Values in the Hadron language itself are constant variables. Varl is a wrapper for [Value]s in the interpreter, combined with mutability for storing in [StackFrame]s.
 *
 * @property value The data value stored in a [StackFrame]
 *
 * @property mutable Boolean. For var's, mutable is true. For val's, mutable is false.
 */
data class Varl(var value: Value, val mutable: Boolean) {
}