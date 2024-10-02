package de.legoshi.flyingpigs;

import de.legoshi.flyingpigs.command.SetSpeed;
import de.legoshi.flyingpigs.command.SpawnPig;
import de.legoshi.flyingpigs.listener.*;
import io.github.revxrsal.cub.bukkit.BukkitCommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.IdentityHashMap;

public final class Main extends JavaPlugin {

    public static IdentityHashMap<Player, PlayerObject> hashMap;
    public static Main plugin;
    public static double speed = 0.5;

    @Override
    public void onEnable() {

        hashMap = new IdentityHashMap<>();
        for(Player all : Bukkit.getOnlinePlayers()) hashMap.put(all, new PlayerObject(all));
        plugin = this;

        BukkitCommandHandler bukkitCommandHandler = BukkitCommandHandler.create(this);
        bukkitCommandHandler.registerCommand(new SpawnPig());
        bukkitCommandHandler.registerCommand(new SetSpeed());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PigDamageListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);
        pluginManager.registerEvents(new PigRideEvent(), this);
        pluginManager.registerEvents(new PlayerUnMount(), this);
        pluginManager.registerEvents(new PlayerDeathListener(), this);

        Bukkit.getConsoleSender().sendMessage("Successfully loaded Flying Pigs plugin!");

    }

    @Override
    public void onDisable() {
        for(Player all : Bukkit.getOnlinePlayers()) {
            Pig oldPig = hashMap.get(all).getPig();
            if(oldPig != null) oldPig.remove();
        }
    }
}
