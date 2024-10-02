package de.legoshi.flyingpigs.command;

import de.legoshi.flyingpigs.Main;
import de.legoshi.flyingpigs.PigMove;
import io.github.revxrsal.cub.annotation.Command;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnPig {

    @Command("pig")
    public void onSpawn(Player player) {
        Location loc = player.getLocation();
        LivingEntity mob = (LivingEntity)player.getWorld().spawnEntity(loc, EntityType.PIG);
        Pig pig = (Pig)mob;
        ItemStack[] itemStacks = new ItemStack[1];
        itemStacks[0] = new ItemStack(Material.ELYTRA, 1);

        pig.setSaddle(true);
        pig.setInvulnerable(true);
        pig.getEquipment().setArmorContents(itemStacks);
        pig.setGliding(true);
        pig.setGravity(false);
        pig.addPassenger(player);

        PigMove.startMove(player);

        Pig oldPig = Main.hashMap.get(player).getPig();

        if(oldPig != null) oldPig.remove();
        Main.hashMap.get(player).setPig(pig);
        player.sendMessage("§6§lMOBS: §fMob custom spawned!");
    }

}
