import environment.Environment
import environment.StackFrame
import statements.ValueStatement
import values.VoidValue

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