package world.cepi.example

import net.minestom.server.command.builder.arguments.Argument

fun Argument<*>.attatchFuzz(fuzz: SubFuzz) = this.setCallback { sender, exception ->
    fuzz(sender, exception.input)
}