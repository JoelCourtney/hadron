package statements

import HadronFile
import environment.Environment
import java.io.File

data class ImportStatement(val module: String): Statement {
    override fun exec(env: Environment) {
        val localFile = File("$module.hn")
        val source = (if (localFile.exists()) {
            HadronParser.parseHadron(localFile.readText())
        } else {
            val hadronRoot = System.getenv("HADRON_ROOT").removeSuffix("/")
            val builtinFile = File("$hadronRoot/src/main/hadron/$module.hn")
            HadronParser.parseHadron(builtinFile.readText())
        })
                ?: TODO("make an error for this")
        val frame = source.import()
        env.absorbFrame(frame)
    }
}