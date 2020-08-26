package values

import environment.Environment
import expressions.Expression

interface Value: Expression {
     fun add(with: Value): Value
     fun subtract(with: Value): Value
     fun multiply(with: Value): Value
     fun divide(with: Value): Value
     fun exponentiate(with: Value): Value
     fun lessThan(with: Value): Value
     fun greaterThan(with: Value): Value
     fun lessThanOrEqual(with: Value): Value
     fun greaterThanOrEqual(with: Value): Value

     fun negate(): Value

     override fun eval(env: Environment): Value {
         return this
     }
}