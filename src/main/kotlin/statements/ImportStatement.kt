package statements

import HadronFile
import environment.Environment
import java.io.File

data class ImportStatement(val module: String): Statement {
    override fun exec(env: Environment) {
        var source: HadronFile? = null
        val localFile = File("$module.hn")
        if (localFile.exists()) {
            source = HadronParser.parseHadron(localFile.readText())
        } else {
            val hadronRoot = System.getenv("HADRON_ROOT")
            if (hadronRoot != null) {
                val builtinFile = File(hadronRoot + "/src/main/hadron/$module.hn")
                source = HadronParser.parseHadron(builtinFile.readText())
            }
        }
        if (source == null) {
            TODO("make an error for this")
        }
        val frame = source.import()
        env.absorbFrame(frame)
    }
}