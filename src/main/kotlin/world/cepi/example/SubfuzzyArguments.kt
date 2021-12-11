package world.cepi.example

import me.xdrop.fuzzywuzzy.FuzzySearch
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.arguments.ArgumentWord

typealias FuzzProvider = CommandSender.(input: String, possibility: String, chance: Int) -> Unit

data class SubFuzz(val possibilities: List<String>, val provider: FuzzProvider)  {
    operator fun invoke(sender: CommandSender, input: String) {
        FuzzySearch.extractTop(input, possibilities, 1)
            .firstOrNull()
            ?.let {
                provider(
                    sender,
                    input,
                    it.string,
                    it.score
                )
            }
    }
}
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