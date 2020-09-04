package errors

import expressions.BinaryOperation
import values.Value

class InvalidBinaryOperationError(val op: BinaryOperation, val left: Value, val right: Value): Throwable()