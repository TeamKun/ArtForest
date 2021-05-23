package net.kunmc.lab.artforest;

import net.kunmc.lab.artforest.cmd.MainCommandExecutor;
import net.kunmc.lab.artforest.gm.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArtForest extends JavaPlugin {

    static GameManager gm;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Minecraft Version: " + KeiLib.a(this));
        KeiLib.a("af", new MainCommandExecutor(this));

        gm = new GameManager(this);
        gm.init(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static GameManager getgm(){
        return gm;
    }
}
