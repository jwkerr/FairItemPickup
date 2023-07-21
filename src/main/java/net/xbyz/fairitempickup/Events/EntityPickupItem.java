package net.xbyz.fairitempickup.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
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
    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
            Item item = event.getItem();

            Location location = item.getLocation();
            Collection<Player> nearbyPlayers = location.getNearbyPlayers(1, 0.5);

            if (!nearbyPlayers.isEmpty()) {
                List<Player> nearbyPlayersList = new ArrayList<>(nearbyPlayers);

                Random random = new Random();
                int randomChoice = random.nextInt(nearbyPlayers.size());
                Player player = nearbyPlayersList.get(randomChoice);

                player.getInventory().addItem(item.getItemStack());
                Bukkit.getWorlds().get(0).playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.2f, 1.6f + random.nextFloat() * (3.4f - 1.6f));

                item.remove();
            }
        }
    }
}
