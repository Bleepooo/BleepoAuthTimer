package dev.bleepo.main.events;

import dev.bleepo.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.nio.charset.MalformedInputException;

public class chat implements Listener {
    private final Main plugin;

    public chat(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (plugin.getConfig().getBoolean("prevent_chat")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e) {
        if (plugin.getConfig().getBoolean("prevent_commands")) {
            e.setCancelled(true);
        }
    }
}
