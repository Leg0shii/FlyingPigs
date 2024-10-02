package de.legoshi.flyingpigs.listener;

import de.legoshi.flyingpigs.PigMove;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PigRideEvent implements Listener {

    @EventHandler
    public void onPigRide(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();
        Pig pig = (Pig) event.getRightClicked();
        if(!pig.hasGravity()) {
            PigMove.startMove(player);
            player.sendMessage("§7Entered Pig!");
        }
    }

}

