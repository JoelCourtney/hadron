package builtins

val builtinRegistry: Map<String, BuiltinFunction> = mapOf(
    Pair("println", PrintlnBuiltin)
)