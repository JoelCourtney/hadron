package environment

import values.Value
import values.VoidValue

data class StackFrame(val deferTo: StackFrame?, val varls: MutableMap<String, Varl> = mutableMapOf()) {
    var latestValue: Value = VoidValue
        set(value) {
            if (value != VoidValue) field = value
        }

        fun getVarl(name: String): Value {
        val varl = varls[name]
        if (varl != null) {
            return varl.v
        } else {
            try {
                return deferTo!!.getVarl(name)
            } catch (e: NullPointerException) {
                TODO("make an error for this")
            }
        }
    }

    fun declareVarl(name: String, v: Varl) {
        varls[name] = v
    }

    fun assignVarl(name: String, v: Value) {
        val varl = varls[name]
        if (varl != null) {
            if (varl.mutable) {
                varl.v = v
            } else {
                TODO("make an error for this")
            }
        } else {
            try {
                deferTo!!.assignVarl(name, v)
            } catch (e: java.lang.NullPointerException) {
                TODO("make an error for this")
            }
        }
    }
}