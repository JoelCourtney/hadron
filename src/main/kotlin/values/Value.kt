package values

import environment.Environment
import errors.InvalidBinaryOperationError
import errors.InvalidUnaryOperationError
import expressions.BinaryOperation
import expressions.Expression
import expressions.UnaryOperation

/**
 * Interface for all Hadron data (values)
 *
 * Value classes double as both nodes in the parse tree and as containers for data in the [Environment]. Evaluating a value in the parse tree returns itself.
 *
 * Subclasses must implement all of the operations that they use. The default behavior is to throw an error. Subclasses are not required to implement all of the operator functions. For example, [StringValue] and [VoidValue] cannot use most operations, so they do not implement them.
 *
 * @see Expression
 */
interface Value: Expression {
     /**
      * Unwrap the data stored inside this Value.
      *
      * @return The object wrapped in this value, or null for [NullValue].
      *
      * @throws UnwrapVoidValueError
      */
     fun unwrap(): Any? { return null }

     /**
      * Add two values.
      *
      * Called when the left operand cannot be added to.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun add(with: Value): Value {
         throw InvalidBinaryOperationError(BinaryOperation.ADD, this, with)
     }

     /**
      * Subtract two values.
      *
      * Called when the left operand cannot be subtracted from.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun subtract(with: Value): Value {
         throw InvalidBinaryOperationError(BinaryOperation.SUBTRACT, this, with)
     }

     /**
      * Multiply two values.
      *
      * Called when the left operand cannot be multiplied.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun multiply(with: Value): Value {
         throw InvalidBinaryOperationError(BinaryOperation.MULTIPLY, this, with)
     }

     /**
      * Divide two values.
      *
      * Called when the left operand cannot be divided.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun divide(with: Value): Value {
          throw InvalidBinaryOperationError(BinaryOperation.DIVIDE, this, with)
     }

     /**
      * Raise a value to a power.
      *
      * Called when the left operand cannot be exponentiated.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun exponentiate(with: Value): Value {
          throw InvalidBinaryOperationError(BinaryOperation.EXPONENTIATE, this, with)
     }

     /**
      * Test if two values are equal.
      *
      * Called when the left operand cannot be tested for equality.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun equal(with: Value): BooleanValue {
          throw InvalidBinaryOperationError(BinaryOperation.EQUAL, this, with)
     }

     /**
      * Test if two values are not equal.
      *
      * Called when the left operand cannot be tested for equality.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun notEqual(with: Value): BooleanValue {
          throw InvalidBinaryOperationError(BinaryOperation.NOT_EQUAL, this, with)
     }

     /**
      * Test if the left operand is less than the right operand.
      *
      * Called when the left operand cannot be tested for ordered inequality.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun lessThan(with: Value): BooleanValue {
          throw InvalidBinaryOperationError(BinaryOperation.LESS_THAN, this, with)
     }

     /**
      * Test if the left operand is greater than the right operand.
      *
      * Called when the left operand cannot be tested for ordered inequality.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun greaterThan(with: Value): BooleanValue {
          throw InvalidBinaryOperationError(BinaryOperation.GREATER_THAN, this, with)

     }

     /**
      * Test if the left operand is less than or equal to the right operand.
      *
      * Called when the left operand cannot be tested for ordered inequality.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun lessThanOrEqual(with: Value): BooleanValue {
          throw InvalidBinaryOperationError(BinaryOperation.LESS_THAN_OR_EQUAL, this, with)
     }

     /**
      * Test if the left operand is greater than or equal to the right operand.
      *
      * Called when the left operand cannot be tested for ordered inequality.
      *
      * @throws[InvalidBinaryOperationError] always
      */
     fun greaterThanOrEqual(with: Value): BooleanValue {

          throw InvalidBinaryOperationError(BinaryOperation.GREATER_THAN_OR_EQUAL, this, with)
     }

     /**
      * Negate a value. Override to implement this operation.
      *
      * Called when the operand cannot be negated.
      *
      * @throws[InvalidUnaryOperationError] always
      */
     fun negate(): Value {
         throw InvalidUnaryOperationError(UnaryOperation.NEGATE, this)
     }

     /**
      * Base case of expression eval. Returns self.
      */
     override fun eval(env: Environment): Value {
         return this
     }
}