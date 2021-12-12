package world.cepi.subfuzzy

import net.minestom.server.command.builder.arguments.ArgumentWord

class SubFuzzArgument(
    id: String,
    val subFuzz: SubFuzz
) : ArgumentWord(id) {
    init {
        from(*subFuzz.possibilities.toTypedArray())

        setCallback { sender, exception ->
            subFuzz(sender, exception.input)
        }
    }

}