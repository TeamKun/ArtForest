package net.kunmc.lab.artforest.event;

import net.kunmc.lab.artforest.ArtForest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class QuitEventListener implements Listener {
    public QuitEventListener(ArtForest artForest) {
    }

    @EventHandler
    public void on(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(ArtForest.getgm().drawer == null) return;
        if(ArtForest.getgm().drawer.getUniqueId().equals(p.getUniqueId())){
            ArtForest.getgm().draweruidcache = p.getUniqueId();
        }
    }
}
