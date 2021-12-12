package world.cepi.subfuzzy

import net.minestom.server.extensions.Extension;

class SubfuzzyExtension : Extension() {

    override fun initialize() {
        logger.info("[Subfuzzy] has been enabled!")
    }

    override fun terminate() {
        logger.info("[Subfuzzy] has been disabled!")
    }

}
