package de.legoshi.flyingpigs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;

public class PigMove {

    public static void startMove(Player player) {

        int id = Bukkit.getScheduler().runTaskTimer(Main.plugin, () -> {
            Pig pig = Main.hashMap.get(player).getPig();
            pig.setVelocity(player.getLocation().getDirection().multiply(Main.speed));
            pig.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
        }, 0, 1).getTaskId();
        Main.hashMap.get(player).setId(id);

    }

}
