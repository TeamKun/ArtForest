package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import net.kunmc.lab.artforest.Kei;
import org.bukkit.scheduler.BukkitRunnable;

public class NewWaveTask extends BukkitRunnable {
    public NewWaveTask(ArtForest plugin, int c) {
        count = c;
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
    int count = 5;
    @Override
    public void run() {
        if(count <= 0){
            ArtForest.getgm().Next();
            this.cancel();
        }
        Kei.bac("Next: " + count);
        count--;
    }
}
