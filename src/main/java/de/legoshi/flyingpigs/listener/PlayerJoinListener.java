package de.legoshi.flyingpigs.listener;

import de.legoshi.flyingpigs.Main;
import de.legoshi.flyingpigs.PlayerObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        PlayerObject playerObject = new PlayerObject(event.getPlayer());
        Main.hashMap.put(event.getPlayer(), playerObject);

    }

}
