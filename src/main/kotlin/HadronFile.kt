import environment.Environment
import environment.StackFrame
import statements.Statement

/**
 * Hadron code read from a file.
 *
 * @property statements A list of [Statement]s that have already been read and parsed from a file.
 */
data class HadronFile(val statements: List<Statement>) {
    /**
     * Executes the statements sequentially. Should only be called for the primary file given as command line argument.
     */
    fun exec() {
        import()
    }

    /**
     * Executes the statements sequentially in a new base-level environment, and returns the resulting base [StackFrame].
     *
     * Used for importing the environment created by one file into the environment of another.
     *
     * @return A [StackFrame], the lowest frame of the environment after the last statement has been executed.
     */
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