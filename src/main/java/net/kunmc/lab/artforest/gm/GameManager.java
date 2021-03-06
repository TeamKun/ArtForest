package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.util.*;

public class GameManager {

    private static class cc {
        private static org.bukkit.ChatColor red = org.bukkit.ChatColor.RED;
        private static org.bukkit.ChatColor black = org.bukkit.ChatColor.BLACK;
        private static org.bukkit.ChatColor blue = org.bukkit.ChatColor.BLUE;
        private static org.bukkit.ChatColor yellow = org.bukkit.ChatColor.YELLOW;
        private static org.bukkit.ChatColor pink = org.bukkit.ChatColor.LIGHT_PURPLE;
        private static org.bukkit.ChatColor purple = org.bukkit.ChatColor.DARK_PURPLE;
        private static org.bukkit.ChatColor lime = org.bukkit.ChatColor.GREEN;
        private static org.bukkit.ChatColor green = org.bukkit.ChatColor.DARK_GREEN;
        private static org.bukkit.ChatColor aqua = org.bukkit.ChatColor.AQUA;
        private static org.bukkit.ChatColor bold = org.bukkit.ChatColor.BOLD;
        private static org.bukkit.ChatColor graydark = org.bukkit.ChatColor.DARK_GRAY;
        private static org.bukkit.ChatColor gray = org.bukkit.ChatColor.GRAY;
        private static org.bukkit.ChatColor gold = org.bukkit.ChatColor.GOLD;
        private static org.bukkit.ChatColor white = org.bukkit.ChatColor.WHITE;
        private static org.bukkit.ChatColor italic = org.bukkit.ChatColor.ITALIC;
        private static org.bukkit.ChatColor strike = org.bukkit.ChatColor.STRIKETHROUGH;
        private static org.bukkit.ChatColor under = org.bukkit.ChatColor.UNDERLINE;
        private static org.bukkit.ChatColor bluedark = org.bukkit.ChatColor.DARK_BLUE;
        private static org.bukkit.ChatColor reddark = org.bukkit.ChatColor.DARK_RED;
        private static org.bukkit.ChatColor magic = org.bukkit.ChatColor.MAGIC;
    }

    private static class gm {
        private static org.bukkit.GameMode g0 = org.bukkit.GameMode.SURVIVAL;
        private static org.bukkit.GameMode g1 = org.bukkit.GameMode.CREATIVE;
        private static org.bukkit.GameMode g2 = org.bukkit.GameMode.ADVENTURE;
        private static org.bukkit.GameMode g3 = org.bukkit.GameMode.SPECTATOR;
        private static org.bukkit.GameMode survival = org.bukkit.GameMode.SURVIVAL;
        private static org.bukkit.GameMode creative = org.bukkit.GameMode.CREATIVE;
        private static org.bukkit.GameMode adventure = org.bukkit.GameMode.ADVENTURE;
        private static org.bukkit.GameMode spectator = org.bukkit.GameMode.SPECTATOR;
    }

    private static class dyecolor {
        private static org.bukkit.DyeColor red = org.bukkit.DyeColor.RED;
        private static org.bukkit.DyeColor black = org.bukkit.DyeColor.BLACK;
        private static org.bukkit.DyeColor blue = org.bukkit.DyeColor.BLUE;
        private static org.bukkit.DyeColor yellow = org.bukkit.DyeColor.YELLOW;
        private static org.bukkit.DyeColor brown = org.bukkit.DyeColor.BROWN;
        private static org.bukkit.DyeColor cyan = org.bukkit.DyeColor.CYAN;
        private static org.bukkit.DyeColor green = org.bukkit.DyeColor.GREEN;
        private static org.bukkit.DyeColor lime = org.bukkit.DyeColor.LIME;
        private static org.bukkit.DyeColor orange = org.bukkit.DyeColor.ORANGE;
        private static org.bukkit.DyeColor magenta = org.bukkit.DyeColor.MAGENTA;
        private static org.bukkit.DyeColor gray = org.bukkit.DyeColor.GRAY;
        private static org.bukkit.DyeColor bluelight = org.bukkit.DyeColor.LIGHT_BLUE;
        private static org.bukkit.DyeColor graylight = org.bukkit.DyeColor.LIGHT_GRAY;
        private static org.bukkit.DyeColor pink = org.bukkit.DyeColor.PINK;
        private static org.bukkit.DyeColor white = org.bukkit.DyeColor.WHITE;
        private static org.bukkit.DyeColor purple = org.bukkit.DyeColor.PURPLE;
    }

    private static class dyematerial {
        private static org.bukkit.Material black = org.bukkit.Material.INK_SAC;
        private static org.bukkit.Material red = org.bukkit.Material.RED_DYE;
        private static org.bukkit.Material blue = org.bukkit.Material.BLUE_DYE;
        private static org.bukkit.Material yellow = org.bukkit.Material.YELLOW_DYE;
        private static org.bukkit.Material brown = org.bukkit.Material.BROWN_DYE;
        private static org.bukkit.Material cyan = org.bukkit.Material.CYAN_DYE;
        private static org.bukkit.Material green = org.bukkit.Material.GREEN_DYE;
        private static org.bukkit.Material lime = org.bukkit.Material.LIME_DYE;
        private static org.bukkit.Material orange = org.bukkit.Material.ORANGE_DYE;
        private static org.bukkit.Material magenta = org.bukkit.Material.MAGENTA_DYE;
        private static org.bukkit.Material gray = org.bukkit.Material.GRAY_DYE;
        private static org.bukkit.Material bluelight = org.bukkit.Material.LIGHT_BLUE_DYE;
        private static org.bukkit.Material graylight = org.bukkit.Material.LIGHT_GRAY_DYE;
        private static org.bukkit.Material pink = org.bukkit.Material.PINK_DYE;
        private static org.bukkit.Material white = org.bukkit.Material.WHITE_DYE;
        private static org.bukkit.Material purple = org.bukkit.Material.PURPLE_DYE;
    }

    private static class sound {
        private static void levelup(org.bukkit.entity.Player p, float vol) {
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, vol, 0f);
        }

        private static void dragondie(org.bukkit.entity.Player p, float vol) {
            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, vol, 0f);
        }

        private static void anviluse(org.bukkit.entity.Player p, float vol) {
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, vol, 0f);
        }
    }

    int status;
    // 0 lobby
    // 1 ingame
    // 2 correct
    public Player drawer;
    String answer;
    String trans;
    GameTimerTask timer;
    int timemax = 60;
    int timenow = 0;
    int count = 0;
    int nextcount = 0;
    int nextmax = 10;
    int playmax;
    int invrange;
    ArtForest plugin;
    HashMap<UUID, Integer> points;

    BossBar bdrawer;
    BossBar bplayer;
    BossBar bnext;

    BukkitRunnable barrunnable;
    BukkitRunnable boardrunnable;

    public UUID draweruidcache;

    GameMode cachegamemode;

    Team team;

    public GameManager(ArtForest plugin) {
        this.status = 0;
        this.plugin = plugin;
        reloadConfig();

        this.barrunnable = new BarUpdateTask();
        barrunnable.runTaskTimer(plugin, 2, 2);

        this.boardrunnable = new BoardUpdateTask();
        boardrunnable.runTaskTimer(plugin, 20, 20);

        wordfile = plugin.getConfig().getString("wordfile");

        new InvisibleTask(plugin).runTaskTimer(plugin, 20, 20);
    }

    void reloadConfig() {
        this.playmax = plugin.getConfig().getInt("playcount");
        this.timemax = plugin.getConfig().getInt("playtime");
        this.nextmax = plugin.getConfig().getInt("nexttime");
        this.invrange = plugin.getConfig().getInt("invrange");
    }

    String wordfile;
    List<String> words;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void init(ArtForest plugin) {
        reloadWord(plugin);
        resetPoints();
    }

    void resetPoints() {
        points = new HashMap<>();
    }

    private void reloadWord(ArtForest plugin) {
        words = new ArrayList<>();
        List<String> dummy = Kei.a(new File(plugin.getDataFolder() + File.separator + wordfile));
        for (String str : dummy) {
            words.add(
                    str.replaceAll(str.substring(str.length() - 2), "").replaceAll("???", ":").replaceAll(" ", ":")
            );
        }
        Kei.out("words: " + words.size());
    }

    private void giveArtset(Player p) {
        Kei.a(p, GameMode.CREATIVE, true, plugin);
        Kei.cinv(p, false);
        p.getInventory().clear();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "art give " + p.getName() + " easel");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "art give " + p.getName() + " canvas");

        new BukkitRunnable() {
            @Override
            public void run() {
                Kei.give(p, Kei.i(Material.INK_SAC));
                Kei.give(p, Kei.i(dyematerial.blue));
                Kei.give(p, Kei.i(dyematerial.bluelight));
                Kei.give(p, Kei.i(Material.COCOA_BEANS));
                Kei.give(p, Kei.i(dyematerial.gray));
                Kei.give(p, Kei.i(dyematerial.cyan));
                Kei.give(p, Kei.i(dyematerial.graylight));
                Kei.give(p, Kei.i(dyematerial.green));
                Kei.give(p, Kei.i(dyematerial.lime));
                Kei.give(p, Kei.i(dyematerial.magenta));
                Kei.give(p, Kei.i(dyematerial.orange));
                Kei.give(p, Kei.i(dyematerial.pink));
                Kei.give(p, Kei.i(dyematerial.purple));
                Kei.give(p, Kei.i(dyematerial.red));
                Kei.give(p, Kei.i(Material.BONE_MEAL));
                Kei.give(p, Kei.i(dyematerial.yellow));
            }
        }.runTaskLater(plugin, 3); //?????????????????????????????????????????????????????????
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

    public boolean Playing2() {
        return status == 1;
    }

    public void Start() {
        status = 1;
        resetPoints();
        reloadConfig();
        bdrawer = Bukkit.createBossBar("Loading", BarColor.PINK, BarStyle.SEGMENTED_10);
        bplayer = Bukkit.createBossBar("Loading", BarColor.BLUE, BarStyle.SEGMENTED_10);
        bnext = Bukkit.createBossBar("Loading", BarColor.WHITE, BarStyle.SOLID);
        for (Player p : Bukkit.getOnlinePlayers()) {
            points.put(p.getUniqueId(), 0);
        }
        //Bukkit.getOnlinePlayers().forEach(player -> player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 100, true)));
        Next();
    }

    public void Next() {
        if (count >= playmax) {
            End();
        }

        bnext.removeAll();

        if (status == 2) status = 1;
        count++;
        List<Player> p2 = new ArrayList<>();
        for (OfflinePlayer player : getTeam().getPlayers()) {
            if (player.isOnline()) p2.add((Player) player);
        }
        if (p2.size() < 1) {
            status = 0;
            Kei.bc(GameMessage.NOTFOUNT_DRAWER.message);
            return;
        }
        Collections.shuffle(p2);
        Player p = p2.get(0);
        timenow = 0;
        if (p == null) {
            status = 0;
            Kei.bc(GameMessage.NOTFOUNT_DRAWER.message);
            return;
        }
        drawer = p;
        cachegamemode = drawer.getGameMode();
        String dummy = words.get(new Random().nextInt(words.size()));
        answer = dummy.split("\t")[1];
        trans = dummy.split("\t")[0];
        timer = new GameTimerTask(this);
        timer.runTaskTimer(this.plugin, 20, 20);
        Kei.bc(GameMessage.NEXTDRAWER.message.replaceAll("%player%", p.getName()));
        Kei.psm(p, GameMessage.FIRSTANSWER.message.replaceAll("%answer%", trans));
        giveArtset(p);
    }

    public void End() {
        BoardUpdateTask.update();
        new BukkitRunnable() {
            @Override
            public void run() {
                count = 0;
                timenow = 0;
                drawer = null;
                answer = null;
                timer.cancel();
                timer = null;
                status = 0;
                bnext.removeAll();
                bplayer.removeAll();
                bdrawer.removeAll();
                Kei.bc(GameMessage.GAMEEND.message);
                Bukkit.getOnlinePlayers().
                        forEach(p2 -> Kei.t(p2, GameMessage.GAMEEND_TITLE.message, "", 20, 120, 20));
                Bukkit.getOnlinePlayers().
                        forEach(p2 -> sound.anviluse(p2, 0.43f));
                /*
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.getOnlinePlayers().
                                forEach(player -> player.removePotionEffect(PotionEffectType.INVISIBILITY));
                    }
                }.runTaskLater(plugin, 1);
                */
                List<Map.Entry<UUID, Integer>> list_entries = new ArrayList<Map.Entry<UUID, Integer>>(points.entrySet());
                Collections.sort(list_entries, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));
                int c = 1;
                for (Map.Entry<UUID, Integer> entry : list_entries) {
                    String s = GameMessage.PLACEMENT.message.replaceAll("%rank%", String.valueOf(c)).replaceAll("%player%", Bukkit.getPlayer(entry.getKey()).getName())
                            .replaceAll("%point%", String.valueOf(entry.getValue()));
                    Kei.bc(s);
                    c++;
                }
            }
        }.runTaskLater(plugin, 3);
    }

    public void correct(Player p) {
        status = 2;
        int c = plugin.getConfig().getInt("nexttime");
        int l = timemax - timenow;
        if (points.containsKey(p.getUniqueId())) {
            points.replace(p.getUniqueId(), points.get(p.getUniqueId()) + l);
        } else {
            points.put(p.getUniqueId(), l);
        }
        if (points.containsKey(drawer.getUniqueId())) {
            points.replace(drawer.getUniqueId(), points.get(drawer.getUniqueId()) + l);
        } else {
            points.put(drawer.getUniqueId(), l);
        }
        Kei.a(drawer, cachegamemode, true, plugin);
        Kei.bc(GameMessage.GAMEEND_ANSWER1.message.replaceAll("%answer%", trans));
        Kei.bc(GameMessage.GAMEEND_ANSWER2.message.replaceAll("%player%", p.getName()));
        Kei.bc(GameMessage.GAMEEND_ANSWER3.message.replaceAll("%point%", String.valueOf(l)));
        if (count >= playmax) {
            End();
            return;
        }
        Bukkit.getOnlinePlayers().forEach(p2 -> Kei.t(p2, GameMessage.GAMEENDTITLE_ANSWER1.message.replaceAll("%answer%", trans), GameMessage.GAMEENDTITLE_ANSWER2.message.replaceAll("%player%", p.getName()), 20, 120, 20));
        Bukkit.getOnlinePlayers().forEach(p2 -> sound.levelup(p2, 1));
        Kei.bc(GameMessage.REMAINNEXT.message.replaceAll("%s%", String.valueOf(c)));
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
        int c = plugin.getConfig().getInt("nexttime");
        Kei.a(drawer, cachegamemode, true, plugin);
        Kei.bc(GameMessage.GAMEEND_WRONG.message);
        if (count >= playmax) {
            End();
            return;
        }
        Bukkit.getOnlinePlayers().forEach(p -> Kei.t(p, GameMessage.GAMEENDTITLE_WRONG1.message, GameMessage.GAMEENDTITLE_WRONG2.message, 20, 120, 20));
        Bukkit.getOnlinePlayers().forEach(p2 -> sound.levelup(p2, 1));
        Kei.bc(GameMessage.REMAINNEXT.message.replaceAll("%s%", String.valueOf(c)));
        new NewWaveTask(this.plugin, c).runTaskTimer(this.plugin, 20, 20);
    }

    public void updateBossbar() {
        if (status == 1) {
            String title = "??????: " + (timemax - timenow) + "??? ?????????: " + drawer.getName() + " ??????: %answer%";
            bdrawer.setProgress(1.0d - ((double) timenow / timemax));
            bplayer.setProgress(1.0d - ((double) timenow / timemax));
            bdrawer.setTitle(title.replaceAll("%answer%", trans));
            bplayer.setTitle(title.replaceAll("%answer%", "???"));
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (drawer.getUniqueId().equals(p.getUniqueId())) {
                    if (bplayer.getPlayers().contains(p)) bplayer.removePlayer(p);
                    if (!bdrawer.getPlayers().contains(p)) bdrawer.addPlayer(p);
                } else {
                    if (bdrawer.getPlayers().contains(p)) bdrawer.removePlayer(p);
                    if (!bplayer.getPlayers().contains(p)) bplayer.addPlayer(p);
                }
            }
        } else if (status == 2) {
            String title = "??????: " + (ArtForest.getgm().nextmax - ArtForest.getgm().nextcount) + "??? ?????????: " + drawer.getName() + " ??????: " + trans;
            bdrawer.removeAll();
            bplayer.removeAll();
            bnext.setTitle(title);
            bnext.setProgress(1.0d - ((double) nextcount / nextmax));
            Bukkit.getOnlinePlayers().forEach(pl -> bnext.addPlayer(pl));
        }
    }

    public void clearBoss() {
        if (!barrunnable.isCancelled()) barrunnable.cancel();
        if (!boardrunnable.isCancelled()) boardrunnable.cancel();

        if (bdrawer != null) bdrawer.removeAll();
        if (bplayer != null) bplayer.removeAll();
        if (bnext != null) bnext.removeAll();
    }
}
