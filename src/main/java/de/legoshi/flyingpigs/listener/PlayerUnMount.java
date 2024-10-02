package de.legoshi.flyingpigs.listener;

import de.legoshi.flyingpigs.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class PlayerUnMount implements Listener {

    @EventHandler
    public void onUnMount(VehicleExitEvent event) {
        if (event.getVehicle() instanceof Pig) {
            Pig pig = (Pig) event.getVehicle();
            if (!pig.hasGravity()) {
                Player player = (Player) pig.getPassengers().get(0);
                Bukkit.getScheduler().cancelTask(Main.hashMap.get(player).getId());
                pig.remove();
                player.sendMessage("§7Exited pig!");
            }
        }
    }

}
