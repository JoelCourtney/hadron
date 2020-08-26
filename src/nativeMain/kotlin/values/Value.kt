package values

interface Value: Expression {
     fun add(with: Value): Value
     fun subtract(with: Value): Value
     fun multiply(with: Value): Value
     fun divide(with: Value): Value
     fun exponentiate(with: Value): Value

     override fun eval(): Value {
         return this
     }
}