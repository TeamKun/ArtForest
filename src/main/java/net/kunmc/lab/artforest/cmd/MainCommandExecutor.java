package net.kunmc.lab.artforest.cmd;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.KeiLib;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommandExecutor implements CommandExecutor {
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
        if(KeiLib.pexc(sender)) return true;
        if(KeiLib.agc(args, 1)){
            KeiLib.sm(sender,ChatColor.RESET + "/af status 現在のゲーム状況を表示します。",
                    ChatColor.RESET + "/af game ゲーム関係のコマンドを表示します。");
            return true;
        }
        if(KeiLib.agc(args, 0, "status")){
            KeiLib.sm(sender,"Status: " + ArtForest.getgm().getStatus());
            return true;
        }
        if(KeiLib.agc(args, 0, "game") && KeiLib.agc(args, 2)){
            KeiLib.sm(sender, "/af game start ゲームを開始します。", "/af game stop ゲームを強制終了します。", "/af game words 単語一覧を表示します。");
            return true;
        } else if(KeiLib.agc(args, 1, "words")){
            KeiLib.sm(sender, "===========");
            ArtForest.getgm().getWords().forEach(s -> KeiLib.sm(sender,s));
            KeiLib.sm(sender, "===========", "登録単語数: " + ArtForest.getgm().getWords().size());
            return true;
        } else if(KeiLib.agc(args, 1, "start")){
            if(ArtForest.getgm().Playing()){
                KeiLib.sm(sender, "すでにゲームは開始しています。");
                return true;
            } else {
                KeiLib.sm(sender, "ゲームを開始しました。", "登録単語数: "+ ArtForest.getgm().getWords().size());
                ArtForest.getgm().Start();
                return true;
            }
        }
        return false;
    }
}
