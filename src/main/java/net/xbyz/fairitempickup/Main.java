package net.xbyz.fairitempickup;

import net.xbyz.fairitempickup.Events.EntityPickupItem;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EntityPickupItem(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
