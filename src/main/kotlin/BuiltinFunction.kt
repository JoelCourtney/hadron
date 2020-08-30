import com.ibm.icu.impl.UResource
import values.Value
import values.VoidValue
import kotlin.reflect.KFunction

class BuiltinFunction(val f: KFunction<*>) {
    operator fun invoke(args: List<Value>): Value {
        return f.call(BuiltinFunctions, args) as Value
    }
}