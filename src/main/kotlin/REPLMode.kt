import environment.Environment
import environment.StackFrame
import statements.ValueStatement

/**
 * Operates the REPL command line interface.
 *
 * Works like a standard REPL mode, with a few limitations. It does not accept multi-line commands. It does not have cursor navigation functionality (i.e. using the arrow keys). Errors are fatal (sadly that's harder to fix than just a try-catch block).
 *
 * @property header The welcome message printed at the beginning of execution.
 * @property prompt The message to print before accepting each input.
 */
class REPLMode {
    val header = "Hadron $version REPL mode.\nThere is no help feature."
    val prompt = "> "
    fun exec() {
        val env = Environment()
        env.push(StackFrame(null))
        println(header)
        print(prompt)
        var line: String? = readLine()
        while (line != null) {
            if (line.isNotEmpty()) {
                val source = HadronParser.parseREPLStatement(line)
                source.exec(env)
                if (source is ValueStatement) {
                    val sf = env.getTop()
                    if (sf.latestValueChanged) {
                        println(sf.latestValue)
                    }
                }
            }
            print(prompt)
            line = readLine()
        }
        env.pop()
    }
}