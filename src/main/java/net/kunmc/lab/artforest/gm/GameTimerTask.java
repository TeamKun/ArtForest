package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.KeiLib;
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
        gm.timenow += 1;
        if(gm.timenow >= gm.timemax){
            gm.Next();
        }
        KeiLib.bac("Remain: " + (gm.timemax - gm.timenow));
    }
}