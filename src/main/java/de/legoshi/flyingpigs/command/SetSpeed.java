package de.legoshi.flyingpigs.command;

import de.legoshi.flyingpigs.Main;
import io.github.revxrsal.cub.annotation.Command;
import org.bukkit.entity.Player;

public class SetSpeed {

    @Command("speed")
    public void onSetSpeed(Player player, String args1) {

        double speed;
        try { speed = Double.parseDouble(args1);
        } catch (NumberFormatException e) {
            player.sendMessage("§c Please enter a number!");
            return;
        }
        Main.speed = speed;

    }

}
