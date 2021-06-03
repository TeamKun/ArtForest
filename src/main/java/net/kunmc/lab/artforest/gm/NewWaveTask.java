package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.Art;
import org.bukkit.scheduler.BukkitRunnable;

public class NewWaveTask extends BukkitRunnable {
    public NewWaveTask(ArtForest plugin, int c) {
        ArtForest.getgm().nextmax = c;
        ArtForest.getgm().nextcount = 0;
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
        if(ArtForest.getgm().nextcount >= ArtForest.getgm().nextmax){
            ArtForest.getgm().Next();
            this.cancel();
        }
        ArtForest.getgm().nextcount += 1;
    }
}
