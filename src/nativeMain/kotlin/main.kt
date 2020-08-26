import values.*

fun main() {
    val a = IntegerValue(5)
    val b = FloatValue(6.2)
    val node = BinaryExpression(BinaryOperation.SUBTRACT, a, b)
    println(node.eval())
}

