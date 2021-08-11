package dev.bleepo.main.events;

import dev.bleepo.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class timer implements Listener {
    private final Main plugin;

    public timer(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Bukkit.getScheduler().runTaskTimer((Plugin) plugin, (Runnable)new Runnable() {
            int time = plugin.getConfig().getInt("time");

            @Override
            public void run() {
                if(this.time == 0) {
                    String message = plugin.getConfig().getString("message");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }

                --this.time;
                String msg = plugin.getConfig().getString("msg");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', msg.replace("{time}", String.valueOf(time)))));
                if(plugin.getConfig().getBoolean("sound")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0f, 1.0f);
                }
            }
        }, 0L, 20L);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0f, 1.0f);
    }
}
