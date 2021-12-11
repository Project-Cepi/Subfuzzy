package world.cepi.example

import me.xdrop.fuzzywuzzy.FuzzySearch
import net.minestom.server.command.CommandSender

typealias FuzzProvider = CommandSender.(input: String, possibility: String, chance: Int) -> Unit

open class SubFuzz(val possibilities: List<String>, val provider: FuzzProvider)  {
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