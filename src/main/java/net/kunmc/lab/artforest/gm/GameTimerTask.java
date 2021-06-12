package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTimerTask extends BukkitRunnable {

    GameManager gm;

    public GameTimerTask(GameManager gm){
        this.gm = gm;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if(!gm.Playing()){
            this.cancel();
        }
        if(gm.timenow >= gm.timemax){
            gm.Wrong();
            this.cancel();
        }
        ArtForest.getgm().updateBossbar();
        gm.timenow += 1;
    }
}
