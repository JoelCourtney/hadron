package values

import errors.UnwrapVoidValueError

/**
 * A void return type.
 *
 * This object is returned from a function call when nothing is returned. It cannot be used or accessed in any way. Assigning this to a variable in Hadron is an error.
 */
object VoidValue: Value