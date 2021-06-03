package net.kunmc.lab.artforest.event;

import net.kunmc.lab.artforest.ArtForest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class JoinEventListener implements Listener {
    public JoinEventListener(ArtForest artForest) {
    }

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(ArtForest.getgm().draweruidcache != null && ArtForest.getgm().draweruidcache.equals(p.getUniqueId())){
            ArtForest.getgm().drawer = p;
        }
    }
}
