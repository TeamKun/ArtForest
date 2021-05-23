package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.KeiLib;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameManager {

    int status;
    // 0 lobby
    // 1 ingame
    Player drawer;
    String answer;
    GameTimerTask timer;
    int timemax = 60*4;
    int timenow = 0;
    int count = 0;

    public GameManager(ArtForest plugin){
        this.status = 0;
    }

    final String wordfile = "word.txt";
    List<String> words;


    public void init(ArtForest plugin){
        reloadWord(plugin);
    }

    private void reloadWord(ArtForest plugin) {
        words = new ArrayList<>();
        words.addAll(KeiLib.a(new File(plugin.getDataFolder() + File.separator + wordfile)));
        KeiLib.out("words: " + words.size());
    }

    private void giveArtset(Player p){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "art give Kei77Hz easel");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "art give Kei77Hz canvas");
    }

    public int getStatus() {
        return status;
    }

    public List<String> getWords() {
        return words;
    }

    public boolean Playing() {
        return status == 1;
    }

    public void Start(){
        status = 1;
        Next();
    }

    public void Next() {
        count++;
        Player p = (Player) Arrays.asList(Bukkit.getOnlinePlayers().toArray()).get(new Random().nextInt(Bukkit.getOnlinePlayers().size()-1));
        timenow = timemax;
        drawer = p;

    }
}
