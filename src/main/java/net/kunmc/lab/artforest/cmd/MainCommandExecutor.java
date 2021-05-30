package net.kunmc.lab.artforest.cmd;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCommandExecutor implements CommandExecutor, TabCompleter {
    public MainCommandExecutor(ArtForest artForest) {
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
                    ChatColor.RESET + "/af game ゲーム関係のコマンドを表示します。");
            return true;
        }

        if(Kei.agc(args, 0, "status")){
            Kei.sm(sender,"Status: " + ArtForest.getgm().getStatus(), "0 - lobby", "1 - ingame", "2 - result");
            return true;
        }
        if(Kei.agc(args, 0, "game") && Kei.agc(args, 2)){
            Kei.sm(sender, "/af game start ゲームを開始します。", "/af game stop ゲームを強制終了します。", "/af game words 単語一覧を表示します。");
            return true;
        } else if(Kei.agc(args, 1, "words")){
            Kei.sm(sender, "===========");
            ArtForest.getgm().getWords().forEach(s -> Kei.sm(sender,s));
            Kei.sm(sender, "===========", "登録単語数: " + ArtForest.getgm().getWords().size());
            return true;
        } else if(Kei.agc(args, 1, "start")){
            if(ArtForest.getgm().Playing()){
                Kei.sm(sender, "すでにゲームは開始しています。");
                return true;
            } else {
                Kei.sm(sender, "ゲームを開始しました。", "登録単語数: "+ ArtForest.getgm().getWords().size());
                ArtForest.getgm().Start();
                return true;
            }
        } else if(Kei.agc(args, 1, "stop")){
            if(ArtForest.getgm().Playing()) {
                ArtForest.getgm().End();
                return true;
            } else {
                Kei.sm(sender, "ゲームが開始していません。");
                return true;
            }
        } else {
            Kei.sm(sender, "/af game start ゲームを開始します。", "/af game stop ゲームを強制終了します。", "/af game words 単語一覧を表示します。");
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
            return Arrays.asList("game", "status");
        } else if(Kei.agc(args, 2)){
            List<String> r = new ArrayList<>();
            for(String s : Arrays.asList("game", "status")){
                if(s.startsWith(args[0])) r.add(s);
            }
            return r;
        } else if(Kei.agc(args, 3)){
            List<String> r = new ArrayList<>();
            for (String s : Arrays.asList("start", "stop", "words")) {
                if (s.startsWith(args[1])) r.add(s);
            }
            return r;
        }
        return null;
    }
}
