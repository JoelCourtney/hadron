import values.Value

class BuiltinFunction(val f: (List<Value>)->Value) {
    operator fun invoke(args: List<Value>): Value {
        return f(args)
    }
}