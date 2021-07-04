package net.kunmc.lab.artforest.gm;

import net.kunmc.lab.artforest.ArtForest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class InvisibleTask extends BukkitRunnable {
    public InvisibleTask(ArtForest plugin) {
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
        if(ArtForest.getgm().Playing2()){
            Player p = ArtForest.getgm().getDrawer();
            if(p.isOnline()){
                for (Entity ent : p.getWorld().getNearbyEntities(p.getLocation(), ArtForest.getgm().invrange, ArtForest.getgm().invrange, ArtForest.getgm().invrange)){
                    if(ent instanceof Player){
                        ((Player) ent).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20*3, 0, true));
                    }
                }
            }
        }
    }
}
