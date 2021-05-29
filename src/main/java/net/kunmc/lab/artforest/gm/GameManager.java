package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

public class GameManager {

    int status;
    // 0 lobby
    // 1 ingame
    // 2 correct
    Player drawer;
    String answer;
    GameTimerTask timer;
    int timemax = 60;
    int timenow = 0;
    int count = 0;
    int playmax = 10;
    ArtForest plugin;
    HashMap<UUID, Integer> points;

    public GameManager(ArtForest plugin){
        this.status = 0;
        this.plugin = plugin;

    }

    final String wordfile = "word.txt";
    List<String> words;


    public void init(ArtForest plugin){
        reloadWord(plugin);
        resetPoints();
    }

    void resetPoints(){
        points = new HashMap<>();
    }

    private void reloadWord(ArtForest plugin) {
        words = new ArrayList<>();
        words.addAll(Kei.a(new File(plugin.getDataFolder() + File.separator + wordfile)));
        Kei.out("words: " + words.size());
    }

    private void giveArtset(Player p){
        Kei.a(p, GameMode.CREATIVE, true, plugin);
        Kei.cinv(p, false);
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
        if(status == 2) status = 1;
        count++;
        Player p = null;
        for (int i = 0; i < 100; i++) { Player cache = Kei.p1p(); if(Kei.a(GameMode.SPECTATOR, cache)) { p = cache; break; } }
        timenow = 0;
        if(p == null) { status = 0; Kei.bc("書き手が見つかりませんでした。"); return; }
        drawer = p;
        answer = words.get(new Random().nextInt(words.size()));
        timer = new GameTimerTask(this);
        timer.runTaskTimer(this.plugin, 20, 20);
        Kei.bc("次の書き手は" + p.getName() + "です。");
        Kei.psm(p, "お題は" + answer + "です。");
        giveArtset(p);
    }

    public void End() {
        count = 0;
        timenow = 0;
        drawer = null;
        answer = null;
        timer.cancel();
        timer = null;
        status = 0;
        Kei.bc("ゲーム終了！");
        List<Map.Entry<UUID, Integer>> list_entries = new ArrayList<Map.Entry<UUID, Integer>>(points.entrySet());
        Collections.sort(list_entries, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));
        int c = 1;
        for(Map.Entry<UUID, Integer> entry : list_entries) {
            Kei.bc(c + "位 " + Bukkit.getPlayer(entry.getKey()).getName() + " " + entry.getValue() + "pts");
            c++;
        }
    }

    public void correct(Player p){
        status = 2;
        int c = 10;
        int l = timemax - timenow;
        if(points.containsKey(p.getUniqueId())){
            points.replace(p.getUniqueId(), points.get(p.getUniqueId()) + l);
        } else {
            points.put(p.getUniqueId(), l);
        }
        if(points.containsKey(drawer.getUniqueId())){
            points.replace(drawer.getUniqueId(), points.get(drawer.getUniqueId()) + l);
        } else {
            points.put(drawer.getUniqueId(), l);
        }
        Kei.a(drawer, GameMode.SPECTATOR, true, plugin);
        Kei.bc("お題は" + answer + "でした。");
        Kei.bc("正解者は" + p.getName() + "でした。");
        Kei.bc("正解者,書き手に" + l + "ポイント追加されます。");
        Kei.bc(c + "秒後に次のゲームが開始します。");
        if(count >= playmax){
            End();
            return;
        }
        new NewWaveTask(this.plugin, c).runTaskTimer(this.plugin, 20, 20);
    }

    public Player getDrawer() {
        return drawer;
    }

    public String getAnswer() {
        return answer;
    }

    public void Wrong() {
        status = 2;
        int c = 10;
        Kei.a(drawer, GameMode.SPECTATOR, true, plugin);
        Kei.bc("正解者はいませんでした。");
        Kei.bc(c + "秒後に次のゲームが開始します。");
        if(count >= playmax){
            End();
            return;
        }
        new NewWaveTask(this.plugin, c).runTaskTimer(this.plugin, 20, 20);
    }
}
