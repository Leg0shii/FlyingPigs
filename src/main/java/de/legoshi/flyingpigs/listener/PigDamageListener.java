package de.legoshi.flyingpigs.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PigDamageListener implements Listener {

    @EventHandler
    public void onPigHit(EntityDamageEvent event) {

        if(event.getEntity().getType() == EntityType.PIG) {
            event.setCancelled(true);
        }

    }

}
