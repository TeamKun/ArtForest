package net.kunmc.lab.artforest.event;

import net.kunmc.lab.artforest.ArtForest;
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

    }
}
