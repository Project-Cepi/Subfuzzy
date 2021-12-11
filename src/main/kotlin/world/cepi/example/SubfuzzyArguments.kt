package world.cepi.example

import me.xdrop.fuzzywuzzy.FuzzySearch
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.arguments.ArgumentWord

class SubfuzzyArguments(
    id: String,
    vararg val subcommands: String,
    val fuzzProvider: CommandSender.(input: String, possibility: String, chance: Int) -> Unit
) : ArgumentWord(id) {



    init {
        from(*subcommands)

        setCallback { sender, exception ->
            FuzzySearch.extractTop(exception.input, subcommands.toList(), 1)
                .firstOrNull()
                ?.let {
                    fuzzProvider(
                        sender,
                        exception.input,
                        it.string,
                        it.score
                    )
                }
        }
    }

}