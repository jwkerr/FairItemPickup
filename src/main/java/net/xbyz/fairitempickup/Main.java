package net.xbyz.fairitempickup;

import net.xbyz.fairitempickup.Events.EntityPickupItem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("throwerPriority", false);
        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getPluginManager().registerEvents(new EntityPickupItem(config), this);
    }
}
