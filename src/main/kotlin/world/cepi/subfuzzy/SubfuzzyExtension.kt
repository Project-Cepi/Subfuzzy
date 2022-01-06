package world.cepi.subfuzzy

import net.minestom.server.extensions.Extension;

class SubfuzzyExtension : Extension() {

    override fun initialize(): LoadStatus {
        logger().info("[Subfuzzy] has been enabled!")

        return LoadStatus.SUCCESS
    }

    override fun terminate() {
        logger().info("[Subfuzzy] has been disabled!")
    }

}
