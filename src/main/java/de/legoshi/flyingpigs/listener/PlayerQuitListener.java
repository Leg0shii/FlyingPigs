package de.legoshi.flyingpigs.listener;

import de.legoshi.flyingpigs.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Pig oldPig = Main.hashMap.get(event.getPlayer()).getPig();
        if(oldPig != null) oldPig.remove();
        Bukkit.getScheduler().cancelTask(Main.hashMap.get(event.getPlayer()).getId());
        Main.hashMap.remove(event.getPlayer());

    }

}
