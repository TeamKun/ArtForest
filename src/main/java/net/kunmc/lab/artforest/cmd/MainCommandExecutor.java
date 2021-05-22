package net.kunmc.lab.artforest.cmd;

import net.kunmc.lab.artforest.ArtForest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MainCommandExecutor implements CommandExecutor {
    public MainCommandExecutor(ArtForest artForest) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return false;
    }
}
