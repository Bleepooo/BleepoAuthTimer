package dev.bleepo.main.events;

import dev.bleepo.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class chat implements Listener {
    private final Main plugin;

    public chat(Main plugin) {
        this.plugin = plugin;
    }

    private boolean whitelist;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (plugin.getConfig().getBoolean("prevent-chat")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e) {
        if (plugin.getConfig().getBoolean("prevent-commands")) {
            if (!plugin.getConfig().getStringList("enabled-cmds").contains(e.getMessage().split(" ")[0].toLowerCase())) {
                e.setCancelled(true);
            }
        }
    }
}
