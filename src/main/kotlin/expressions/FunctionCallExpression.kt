package expressions

import builtins.builtinRegistry
import environment.Environment
import environment.StackFrame
import values.FunctionValue
import values.Value
import values.VoidValue

data class FunctionCallExpression(val functionName: String, val argExps: List<Expression>): Expression {
    override fun eval(env: Environment): Value {
        val builtin = builtinRegistry[functionName]
        if (builtin != null) {
            return builtin.exec( argExps.map { it.eval(env) })
        }
        val func = env.getVarl(functionName)
        if (func is FunctionValue) {
            if (func.args.size != argExps.size) {
                TODO("make an error for this")
            }
            val args = func.args.zip(argExps.map { it.eval(env) })
            env.push(StackFrame(func.deferTo))
            for ((name, value) in args) {
                env.declareVarl(name, value, false)
            }
            val result = func.exp.eval(env)
            env.pop()
            return result
        } else {
            TODO("make an error for this")
        }
    }
}