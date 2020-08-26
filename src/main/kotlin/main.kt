import environment.Environment
import expressions.BinaryExpression
import expressions.BinaryOperation
import values.*
import java.io.File

fun main() {
    val text = File("test.hn").readText()
    val file = HadronParser.parseHadron(text)
    file.exec()
}