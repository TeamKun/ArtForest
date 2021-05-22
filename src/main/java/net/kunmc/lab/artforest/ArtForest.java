package net.kunmc.lab.artforest;

import net.kunmc.lab.artforest.cmd.MainCommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArtForest extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Minecraft Version: " + KeiLib.a(this));
        KeiLib.a("af", new MainCommandExecutor(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
