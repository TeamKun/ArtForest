package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.KeiLib;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {

    int status;
    // 0 lobby
    // 1 ingame
    Player drawer;
    String answer;
    GameTimerTask timer;
    int timemax = 60;
    int timenow = 0;
    int count = 0;
    int playmax = 10;
    ArtForest plugin;

    public GameManager(ArtForest plugin){
        this.status = 0;
        this.plugin = plugin;
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
        KeiLib.a(p, GameMode.CREATIVE);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "art give " + p.getName() + " easel");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "art give " + p.getName() + " canvas");
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
        if(count >= playmax){
            End();
        }
        count++;
        Player p = null;
        int c = 0;
        while(p == null || c >= 100){ Player cache = KeiLib.p1p(); p = KeiLib.gm(cache) == GameMode.SPECTATOR ? cache : null; c++; }
        timenow = 0;
        drawer = p;
        answer = words.get(new Random().nextInt(words.size()));
        if(timer == null) {
            timer = new GameTimerTask(this);
            timer.runTaskTimer(this.plugin, 20, 20);
        }
        KeiLib.bc("次の書き手は" + p.getName() + "です。");
        KeiLib.psm(p, "お題は" + answer + "です。");
        giveArtset(p);
    }

    public void End() {
        count = 0;
        timenow = 0;
        drawer = null;
        answer = null;
        timer = null;
        status = 0;
    }
}
