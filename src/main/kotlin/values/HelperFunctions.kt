package values

import kotlin.math.pow

fun Long.pow(with: Long): Long {
    if (with < 0) return 0
    var result: Long = 1
    for (i in 1..with) {
        result *= this
    }
    return result
}

fun Long.pow(with: Double): Double {
    return (this.toDouble()).pow(with)
}

fun Boolean.toLong(): Long = if (this) 1 else 0
fun Boolean.toInt(): Int = if (this) 1 else 0
