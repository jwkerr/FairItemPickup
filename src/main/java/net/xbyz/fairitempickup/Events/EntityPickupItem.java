package net.xbyz.fairitempickup.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class EntityPickupItem implements Listener {
    private final FileConfiguration config;

    public EntityPickupItem(FileConfiguration config) {
        this.config = config;
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
            Item item = event.getItem();

            Collection<Player> nearbyPlayers = item.getLocation().getNearbyPlayers(1, 0.5);

            if (!nearbyPlayers.isEmpty()) {
                List<Player> nearbyPlayersList = new ArrayList<>(nearbyPlayers);
                Random random = new Random();
                Player player;

                if (config.getBoolean("throwerPriority") && item.getThrower() != null && nearbyPlayersList.contains(Bukkit.getPlayer(item.getThrower()))) {
                    player = Bukkit.getPlayer(item.getThrower());
                } else {
                    player = nearbyPlayersList.get(random.nextInt(nearbyPlayersList.size()));
                }
                player.getInventory().addItem(item.getItemStack());
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.2f, 1.6f + random.nextFloat() * (3.4f - 1.6f));

                item.remove();
            }
        }
    }
}
