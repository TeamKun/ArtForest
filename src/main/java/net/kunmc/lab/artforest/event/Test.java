package net.kunmc.lab.artforest.event;

import net.kunmc.lab.artforest.ArtForest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.List;

public class Test implements Listener {
    public Test(ArtForest artForest) {
    }

    @EventHandler
    public void on(PlayerItemHeldEvent e){
        e.getPlayer().sendMessage("M: " + e.getPlayer().getInventory().getItemInMainHand().getType() + " D:" + e.getPlayer().getInventory().getItemInMainHand().getDurability());
    }
}
