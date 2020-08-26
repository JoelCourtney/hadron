package expressions

import environment.Environment
import values.Value

interface Expression {
    fun eval(env: Environment): Value
}