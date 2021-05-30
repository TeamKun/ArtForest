package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import net.kunmc.lab.artforest.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BoardUpdateTask extends BukkitRunnable {
    public BoardUpdateTask(){
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if(ArtForest.getgm().getStatus() == 1 || ArtForest.getgm().getStatus() == 2){
            List<Map.Entry<UUID, Integer>> list_entries = new ArrayList<Map.Entry<UUID, Integer>>(ArtForest.getgm().points.entrySet());
            Collections.sort(list_entries, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));
            for(Player p : Bukkit.getOnlinePlayers()){
                if(list_entries.size() < 2) {
                    ScoreboardUtil.unrankedSidebarDisplay(p,
                            "お絵かきの森",
                    ChatColor.GREEN + " ",
                    ChatColor.GREEN + "現在の順位:",
                    ChatColor.WHITE + "1位 " + Bukkit.getPlayer(list_entries.get(0).getKey()).getName() + " " + list_entries.get(0).getValue() + "pts",
                    ChatColor.RED + " ",
                    ChatColor.YELLOW+ " ",
                    ChatColor.WHITE + "あなたの順位: " + getV(p.getUniqueId()) + "位",
                    ChatColor.WHITE + "あなたのポイント: " + ArtForest.getgm().points.get(p.getUniqueId()) + "pts",
                    ChatColor.LIGHT_PURPLE + "");
                } else if(list_entries.size() < 3){
                    ScoreboardUtil.unrankedSidebarDisplay(p,
                            "お絵かきの森",
                            ChatColor.GREEN + " ",
                            ChatColor.GREEN + "現在の順位:",
                            ChatColor.WHITE + "1位 " + Bukkit.getPlayer(list_entries.get(0).getKey()).getName() + " " + list_entries.get(0).getValue() + "pts",
                            ChatColor.WHITE + "2位 " + Bukkit.getPlayer(list_entries.get(1).getKey()).getName() + " " + list_entries.get(1).getValue() + "pts",
                            ChatColor.RED + " ",
                            ChatColor.YELLOW+ " ",
                            ChatColor.WHITE + "あなたの順位: " + getV(p.getUniqueId()) + "位",
                            ChatColor.WHITE + "あなたのポイント: " + ArtForest.getgm().points.get(p.getUniqueId()) + "pts",
                            ChatColor.LIGHT_PURPLE + "");
                } else {
                    ScoreboardUtil.unrankedSidebarDisplay(p,
                            "お絵かきの森",
                            ChatColor.GREEN + " ",
                            ChatColor.GREEN + "現在の順位:",
                            ChatColor.WHITE + "1位 " + Bukkit.getPlayer(list_entries.get(0).getKey()).getName() + " " + list_entries.get(0).getValue() + "pts",
                            ChatColor.WHITE + "2位 " + Bukkit.getPlayer(list_entries.get(1).getKey()).getName() + " " + list_entries.get(1).getValue() + "pts",
                            ChatColor.WHITE + "3位 " + Bukkit.getPlayer(list_entries.get(2).getKey()).getName() + " " + list_entries.get(2).getValue() + "pts",
                            ChatColor.RED + " ",
                            ChatColor.YELLOW+ " ",
                            ChatColor.WHITE + "あなたの順位: " + getV(p.getUniqueId()) + "位",
                            ChatColor.WHITE + "あなたのポイント: " + ArtForest.getgm().points.get(p.getUniqueId()) + "pts",
                            ChatColor.LIGHT_PURPLE + "");
                }
            }
        } else if(ArtForest.getgm().getStatus() == 0){

        }
    }

    int getV(UUID uid){
        List<Map.Entry<UUID, Integer>> list_entries = new ArrayList<Map.Entry<UUID, Integer>>(ArtForest.getgm().points.entrySet());
        Collections.sort(list_entries, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));
        for (int i = 0; i < list_entries.size(); i++) {
            if(list_entries.get(i).getKey() == uid) return i+1;
        }
        return 0;
    }
}
