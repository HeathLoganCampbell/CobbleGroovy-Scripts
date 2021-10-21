package scripts.global

import dev.cobblesword.cobblegroovy.tools.CC
import me.lucko.helper.Events
import org.bukkit.event.player.AsyncPlayerChatEvent

Events.subscribe(AsyncPlayerChatEvent.class).handler {
    def player = it.getPlayer()
    player.sendMessage(CC.bAqua + "Chitty chatty")
}.bindWith(registry)
