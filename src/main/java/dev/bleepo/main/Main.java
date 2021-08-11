package dev.bleepo.main;

import dev.bleepo.main.events.timer;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.AQUA + "BleeposAuthTimer" + ChatColor.GREEN + "is Loaded and Enabled!");
        getServer().getPluginManager().registerEvents(new timer(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.AQUA + "BleeposAuthTimer" + ChatColor.RED + "is Unloaded and Diabled!");
    }
}
