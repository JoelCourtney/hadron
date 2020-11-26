import java.io.File

/**
 * Entry point of the Hadron interpreter.
 *
 * @param args A list containing the path of a single file to execute, or an empty list for REPL mode.
 */
fun main(args: Array<String>) {
    if (args.size == 1) {
        val source = HadronParser.parseHadron(File(args[0]).readText())
        source.exec()
    } else {
        val repl = REPLMode()
        repl.exec()
    }
}