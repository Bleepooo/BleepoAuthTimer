package dev.bleepo.main.events;

import dev.bleepo.main.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.util.logging.Level;

public class freeze implements Listener {
    private final Main plugin;

    public freeze (Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSpawn(PlayerRespawnEvent e) {
        if (plugin.getConfig().getBoolean("freeze.freeze")) {
            e.setRespawnLocation(lockloc());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("freeze.freeze")) {
            e.getPlayer().teleport(lockloc());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (plugin.getConfig().getBoolean("freeze.freeze")) {
            e.setCancelled(true);
        }
    }

    private Location lockloc() {
        if (plugin.getServer().getWorld(plugin.getConfig().getString("freeze.world")) == null) {
            plugin.getLogger().log(Level.SEVERE, "Invalid World Name! Please Check the configuration file.");
            return null;
        }
        return new Location(plugin.getServer().getWorld(plugin.getConfig().getString("freeze.world")), plugin.getConfig().getInt("freeze.x"), plugin.getConfig().getInt("freeze.y"), plugin.getConfig().getInt("freeze.z"));
    }

}
