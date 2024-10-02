package de.legoshi.flyingpigs.listener;

import de.legoshi.flyingpigs.Main;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Pig pig = Main.hashMap.get(event.getEntity()).getPig();
        if(pig != null) pig.remove();

    }

}
