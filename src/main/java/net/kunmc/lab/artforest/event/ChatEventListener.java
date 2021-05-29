package net.kunmc.lab.artforest.event;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.gm.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEventListener implements Listener {
    ArtForest af;

    public ChatEventListener(ArtForest artForest) {
        this.af = artForest;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(ArtForest.getgm().Playing()){
            GameManager gm = ArtForest.getgm();
            if(gm.getDrawer().getUniqueId() != e.getPlayer().getUniqueId()){
                if(e.getMessage().equals(gm.getAnswer())){
                    ArtForest.getgm().correct(e.getPlayer());
                }
            }
        }
    }
}
