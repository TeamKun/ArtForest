package net.kunmc.lab.artforest.cmd;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainCommandExecutor implements CommandExecutor, TabCompleter {
    ArtForest plugin;
    public MainCommandExecutor(ArtForest artForest) {
        this.plugin = artForest;
    }

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Kei.pexc(sender)) return true;
        if(Kei.agc(args, 1)){
            Kei.sm(sender,ChatColor.RESET + "/af status 現在のゲーム状況を表示します。",
                    ChatColor.RESET + "/af game ゲーム関係のコマンドを表示します。",
                    ChatColor.RESET + "/af config コンフィグ関係のコマンドを表示します。");
            return true;
        }

        if(Kei.agc(args, 0, "status")){
            Kei.sm(sender,"Status: " + ArtForest.getgm().getStatus(), "0 - lobby", "1 - ingame", "2 - result");
            return true;
        }
        if(Kei.agc(args, 0, "game") && Kei.agc(args, 2)){
            Kei.sm(sender, "/af game start [team] ゲームを開始します。", "/af game stop ゲームを強制終了します。", "/af game words 単語一覧を表示します。");
            return true;
        } else if(Kei.agc(args, 1, "words")){
            Kei.sm(sender, "===========");
            ArtForest.getgm().getWords().forEach(s -> Kei.sm(sender,s));
            Kei.sm(sender, "===========", "登録単語数: " + ArtForest.getgm().getWords().size());
            return true;
        } else if(Kei.agc(args, 1, "start")){
            if(ArtForest.getgm().Playing()) {
                Kei.sm(sender, "すでにゲームは開始しています。");
                return true;
            } else if(Kei.agc(args, 3)){ // af game start []
                Kei.sm(sender, "チームを選択してください。");
                return true;
            } else {
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                Scoreboard board = manager.getMainScoreboard();
                Team team = null;
                for(Team t : board.getTeams()){
                    if(t.getName().equals(args[2])) {
                        team = t;
                        break;
                    }
                }
                if(team == null){
                    Kei.sm(sender, "チームが存在しませんでした。");
                    return true;
                }
                ArtForest.getgm().setTeam(team);
                Kei.sm(sender, "ゲームを開始しました。", "登録単語数: "+ ArtForest.getgm().getWords().size());
                ArtForest.getgm().Start();
                return true;
            }
        } else if(Kei.agc(args, 1, "stop")) {
            if (ArtForest.getgm().Playing()) {
                ArtForest.getgm().End();
                return true;
            } else {
                Kei.sm(sender, "ゲームが開始していません。");
                return true;
            }
        } else if(Kei.agc(args, 0, "config") && Kei.agc(args, 2)){
            Kei.sm(sender, "/af config check 設定内容を表示します。",
                    "/af config nexttime [int] 次のゲームまでの待機時間を設定します",
            "/af config playtime [int] 絵を書く時間を設定します",
            "/af config playcount [int] 絵を書く回数(ゲーム回数)を設定します");
            return true;
        } else if(Kei.agc(args, 1, "check")) {
            Kei.sm(sender,
                    "===========",
                    "nexttime: " + plugin.getConfig().get("nexttime"),
                    "playtime: " + plugin.getConfig().get("playtime"),
                    "playcount: " + plugin.getConfig().get("playcount"),
                    "invrange: " + plugin.getConfig().get("invrange"),
                    "===========",
                    "nexttime: 次のゲームまでの待機時間",
                    "playtime: 絵を書く時間",
                    "playcount: 絵を書く回数(ゲーム回数)",
                    "invrange: 透明化有効範囲",
                    "===========");
            return true;
        } else if(Kei.agc(args, 1, "nexttime")) {
            try {
                Integer i = Integer.parseInt(args[2]);
                plugin.getConfig().set("nexttime", i);
                plugin.saveConfig();
                Kei.sm(sender, "nexttimeを" + i + "に変更しました。");
            } catch (Exception ex){
                Kei.sm(sender, "第二引数には数値(整数)を入力してください。");
            }
            return true;
        } else if(Kei.agc(args, 1, "playtime")) {
            try {
                Integer i = Integer.parseInt(args[2]);
                plugin.getConfig().set("playtime", i);
                plugin.saveConfig();
                Kei.sm(sender, "playtimeを" + i + "に変更しました。");
            } catch (Exception ex){
                Kei.sm(sender, "第二引数には数値(整数)を入力してください。");
            }
            return true;
        } else if(Kei.agc(args, 1, "playcount")) {
            try {
                Integer i = Integer.parseInt(args[2]);
                plugin.getConfig().set("playcount", i);
                plugin.saveConfig();
                Kei.sm(sender, "playcountを" + i + "に変更しました。");
            } catch (Exception ex){
                Kei.sm(sender, "第二引数には数値(整数)を入力してください。");
            }
            return true;
        } else if(Kei.agc(args, 1, "invrange")) {
            try {
                Integer i = Integer.parseInt(args[2]);
                plugin.getConfig().set("invrange", i);
                plugin.saveConfig();
                Kei.sm(sender, "invrangeを" + i + "に変更しました。");
            } catch (Exception ex){
                Kei.sm(sender, "第二引数には数値(整数)を入力してください。");
            }
            return true;
        } else {
            Kei.sm(sender, "/af config check 設定内容を表示します。",
                    "/af config nexttime [int] 次のゲームまでの待機時間を設定します",
                    "/af config playtime [int] 絵を書く時間を設定します",
                    "/af config playcount [int] 絵を書く回数(ゲーム回数)を設定します");
            return true;
        }
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command.  For players tab-completing a
     *                command inside of a command block, this will be the player, not
     *                the command block.
     * @param command Command which was executed
     * @param alias   The alias used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(Kei.agc(args, 1)){
            return Arrays.asList("game", "status", "config");
        } else if(Kei.agc(args, 2)){
            List<String> r = new ArrayList<>();
            for(String s : Arrays.asList("game", "status", "config")){
                if(s.startsWith(args[0])) r.add(s);
            }
            return r;
        } else if(Kei.agc(args, 3)){
            if(args[0].equals("game")) {
                List<String> r = new ArrayList<>();
                for (String s : Arrays.asList("start", "stop", "words")) {
                    if (s.startsWith(args[1])) r.add(s);
                }
                return r;
            } else if(args[0].equals("config")){
                List<String> r = new ArrayList<>();
                for (String s : Arrays.asList("check", "nexttime", "playtime", "playcount", "invrange")) {
                    if (s.startsWith(args[1])) r.add(s);
                }
                return r;
            }
        } else if(Kei.agc(args, 4)){
            if(args[0].equals("game")){
                if(args[1].equals("start")){
                    List<String> r = new ArrayList<>();
                    List<String> a = new ArrayList<>();
                    Bukkit.getScoreboardManager().getMainScoreboard().getTeams().forEach(t -> a.add(t.getName()));
                    for (String s : a) {
                        if (s.startsWith(args[2])) r.add(s);
                    }
                    return r;
                }
            } else if(args[0].equals("config")){
                if(args[1].equals("nexttime") || args[1].equals("playtime") || args[1].equals("invrange") || args[1].equals("playcount")) {
                    if(args.length < 4) // /af config XX [int]
                    return Collections.singletonList("[int]");
                }
            }
        }
        return Collections.singletonList("");
    }
}
