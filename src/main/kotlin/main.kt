import units.*
import values.IntegerValue
import values.CommonValues
import java.io.File

fun main() {
    val source = HadronParser.parseHadron(File("test.hn").readText())
    source.exec()
}