package scripts.global

import dev.cobblesword.cobblegroovy.tools.CC
import me.lucko.helper.Commands
import me.lucko.helper.Events
import me.lucko.helper.Schedulers
import me.lucko.helper.hologram.BaseHologram
import me.lucko.helper.hologram.BukkitHologramFactory
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarFlag
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.AsyncPlayerChatEvent

Commands.create().assertPermission("example.command.yeet")
                .assertPlayer()
                 .handler(sender -> {
                     sender.sender().sendMessage(ChatColor.RED.toString() + "Weeee")
                     BaseHologram hologram = new BukkitHologramFactory()
                             .newHologram(Position.of(sender.sender().getLocation()),
                                     [
                                             CC.red + "Hello world",
                                             "I Am Iron Man"
                                     ])
                     hologram.spawn()

                     BossBar bossBar = Bukkit.createBossBar("yeet world", BarColor.WHITE, BarStyle.SOLID, BarFlag.DARKEN_SKY)
                     bossBar.addPlayer(sender.sender())
                 }).registerAndBind(registry, "yeet")


Schedulers.async().runRepeating(() -> {
    Bukkit.broadcastMessage(CC.red + "Example")
}, 20, 20).bindWith(registry)

Events.subscribe(BlockPlaceEvent.class).handler{
    Block block = it.getBlock()
    block.setType(Material.GOLD_BLOCK)
}.bindWith(registry)

Events.subscribe(AsyncPlayerChatEvent.class).handler{
    it.setFormat(CC.red + "%s: %s")
    it.getPlayer().sendMessage("ABCCC")
}.bindWith(registry)