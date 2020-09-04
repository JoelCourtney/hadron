package errors

import expressions.UnaryOperation
import values.Value

class InvalidUnaryOperationError(val op: UnaryOperation, val operand: Value): Throwable() {
}