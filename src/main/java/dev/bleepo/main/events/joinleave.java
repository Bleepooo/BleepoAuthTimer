package dev.bleepo.main.events;

import dev.bleepo.main.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class joinleave implements Listener {
    private final Main plugin;

    public joinleave(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("hide_join_messages")) {
            e.setJoinMessage("");
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (plugin.getConfig().getBoolean("hide_join_messages")) {
            e.setQuitMessage("");
        }
    }
//e.getPlayer().setGameMode(GameMode.valueOf(forcedGamemode.toUpperCase()));
    @EventHandler
    public void onPlayerJoin$0(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("hide_players")) {
            for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()) {
                e.getPlayer().hidePlayer(plugin, onlinePlayer);
                onlinePlayer.hidePlayer(plugin, e.getPlayer());
            }
        }
    }

    @EventHandler
    public void onPlayerJoin$1(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("gamemode.force")) {
            e.getPlayer().setGameMode(GameMode.valueOf(plugin.getConfig().getString("gamemode.gamemode").toUpperCase()));
        }
    }
}
