import environment.Environment
import environment.StackFrame
import statements.Statement

data class HadronFile(val statements: ArrayList<Statement>) {
    fun exec() {
        val env = Environment()
        env.push(StackFrame(null))
        for (statement in statements) {
            statement.exec(env)
        }
        env.pop()
    }
}