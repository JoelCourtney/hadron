import values.*

fun main() {
    val a = IntegerValue(5)
    val b = IntegerValue(6)
    val node = BinaryExpression(BinaryOperation.EXPONENTIATE, a, b)
    println(node.eval())
}

