package environment

import units.Dimension
import units.UnitPrefix
import values.Value
import values.VoidValue
import units.Unit

data class StackFrame(
    val deferTo: StackFrame?,
    val varls: MutableMap<String, Varl> = mutableMapOf(),
    val units: MutableMap<String, Unit> = mutableMapOf(),
    val unitPrefixes: MutableMap<String, UnitPrefix> = mutableMapOf(),
    val dimensions: MutableMap<String, Dimension> = mutableMapOf()
) {
    var latestValue: Value = VoidValue
        set(value) {
            if (value != VoidValue) field = value
        }

    fun getVarl(name: String): Value {
        val varl = varls[name]
        return varl?.v
            ?: try {
                deferTo!!.getVarl(name)
            } catch (e: NullPointerException) {
                TODO("make an error for this")
            }
    }

    fun getUnit(name: String): Unit {
        val unit = units[name]
        return unit ?:
        try {
            deferTo!!.getUnit(name)
        } catch (e: NullPointerException) {
            TODO("make an error for this")
        }
    }

    fun getUnitPrefix(name: String): UnitPrefix {
        val prefix = unitPrefixes[name]
        return prefix ?:
        try {
            deferTo!!.getUnitPrefix(name)
        } catch (e: NullPointerException) {
            TODO("make an error for this")
        }
    }

    fun getDimension(name: String): Dimension {
        val dim = dimensions[name]
        return dim ?:
        try {
            deferTo!!.getDimension(name)
        } catch (e: NullPointerException) {
            TODO("make an error for this")
        }
    }

    fun declareVarl(name: String, v: Varl) {
        varls[name] = v
    }

    fun declareUnit(name: String, u: Unit) {
        units[name] = u
    }

    fun declareUnitPrefix(name: String, p: UnitPrefix) {
        unitPrefixes[name] = p
    }

    fun declareDimension(name: String, d: Dimension) {
        dimensions[name] = d
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

    fun absorb(f: StackFrame) {
        for ((name, varl) in f.varls) {
            declareVarl(name, varl)
        }
        for ((name, unit) in f.units) {
            declareUnit(name, unit)
        }
        for ((name, prefix) in f.unitPrefixes) {
            declareUnitPrefix(name, prefix)
        }
        for ((name, dim) in f.dimensions) {
            declareDimension(name, dim)
        }
    }
}