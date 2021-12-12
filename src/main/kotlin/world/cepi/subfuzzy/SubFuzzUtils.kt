package world.cepi.subfuzzy

import net.minestom.server.command.builder.arguments.Argument

fun <T> Argument<T>.attatchFuzz(fuzz: SubFuzz): Argument<T> = apply {
    this.setCallback { sender, exception ->
        fuzz(sender, exception.input)
    }
}