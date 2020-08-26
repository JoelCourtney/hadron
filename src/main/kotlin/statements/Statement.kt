package statements

import environment.Environment

interface Statement {
    fun exec(env: Environment)
}