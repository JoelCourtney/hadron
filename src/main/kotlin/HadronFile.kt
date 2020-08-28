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

    fun import(): StackFrame {
        val env = Environment()
        env.push(StackFrame(null))
        for (statement in statements) {
            statement.exec(env)
        }
        val frame = env.getTop()
        env.pop()
        return frame
    }
}