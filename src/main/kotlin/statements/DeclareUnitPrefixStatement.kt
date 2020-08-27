package statements

import environment.Environment
import units.UnitPrefix
import values.NumericValue

data class DeclareUnitPrefixStatement(val name: String, val prefixes: Map<String, NumericValue>): Statement {
    override fun exec(env: Environment) {
        env.declareUnitPrefix(name, UnitPrefix(prefixes))
    }
}