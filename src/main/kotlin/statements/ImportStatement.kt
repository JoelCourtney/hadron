package statements

import HadronFile
import environment.Environment
import java.io.File

data class ImportStatement(val module: String): Statement {
    override fun exec(env: Environment) {
        val source = HadronParser.parseHadron(File("src/main/hadron/$module.hn").readText())
        val frame = source.import()
        env.absorbFrame(frame)
    }
}