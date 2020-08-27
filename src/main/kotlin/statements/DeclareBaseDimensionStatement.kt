package statements

import environment.Environment
import units.BaseDimension

data class DeclareBaseDimensionStatement(val name: String): Statement {
    override fun exec(env: Environment) {
        env.declareDimension(name, BaseDimension(name))
    }
}