package net.kunmc.lab.artforest;

import net.kunmc.lab.artforest.cmd.MainCommandExecutor;
import net.kunmc.lab.artforest.event.ChatEventListener;
import net.kunmc.lab.artforest.gm.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArtForest extends JavaPlugin {

    static GameManager gm;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Minecraft Version: " + Kei.a(this));
        Kei.out("\n", Kei.manatu810());
        Kei.a("af", new MainCommandExecutor(this));
        Kei.a(new ChatEventListener(this), this);

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
