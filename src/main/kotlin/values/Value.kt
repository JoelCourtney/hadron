package values

import environment.Environment
import expressions.Expression

interface Value: Expression {
     fun add(with: Value): Value {
          TODO("make an error for this")
     }

     fun subtract(with: Value): Value {
          TODO("make an error for this")
     }

     fun multiply(with: Value): Value {
          TODO("make an error for this")
     }

     fun divide(with: Value): Value {
          TODO("make an error for this")
     }

     fun exponentiate(with: Value): Value {
          TODO("make an error for this")
     }

     fun equal(with: Value): BooleanValue {
          TODO("make an error for this")
     }

     fun notEqual(with: Value): BooleanValue {
          TODO("make an error for this")
     }

     fun lessThan(with: Value): BooleanValue {
          TODO("make an error for this")
     }

     fun greaterThan(with: Value): BooleanValue {
          TODO("make an error for this")
     }

     fun lessThanOrEqual(with: Value): BooleanValue {
          TODO("make an error for this")
     }

     fun greaterThanOrEqual(with: Value): BooleanValue {
          TODO("make an error for this")
     }

     fun negate(): Value {
          TODO("make an error for this")
     }

     override fun eval(env: Environment): Value {
         return this
     }
}