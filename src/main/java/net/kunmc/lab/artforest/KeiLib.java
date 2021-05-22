package net.kunmc.lab.artforest;
public class KeiLib {
    /**
     * Get the server version from the JavaPlugin class.
     * @param plugin JavaPlugin class
     * @return NMSVersion (ex v1_8_R1)
     */
    public static String a(org.bukkit.plugin.java.JavaPlugin plugin) {
        return plugin.getServer().getClass().getPackage().getName().substring(plugin.getServer().getClass().getPackage().getName().lastIndexOf('.') + 1);
    }
    /**
     * Damage to an entity.
     * @param entity damage-dealing entity
     * @param damage damage amount
     */
    public static void a(org.bukkit.entity.LivingEntity entity, double damage){
        if (entity instanceof org.bukkit.entity.Damageable) ((org.bukkit.entity.Damageable) entity).damage(damage);
    }
    /**
     * Change the player's display.
     * @param player target player
     * @param status hide / show param
     * @param plugin JavaPlugin class
     */
    public static void a(org.bukkit.entity.Player player, boolean status, org.bukkit.plugin.java.JavaPlugin plugin){
        if (status) {
            org.bukkit.Bukkit.getOnlinePlayers().stream().filter(p -> player.getUniqueId() != p.getUniqueId()).forEach(p -> p.showPlayer(plugin, player));
        } else {
            org.bukkit.Bukkit.getOnlinePlayers().stream().filter(p -> player.getUniqueId() != p.getUniqueId()).forEach(p -> p.hidePlayer(plugin, player));
        }
    }
    /**
     * Create an inventory for the specified raw.
     * @param raw inventory raw
     * @param display inventory title
     * @return inventory class (Bukkit.createInventory Holder = null)
     */
    public static org.bukkit.inventory.Inventory a(int raw, String display){
        return org.bukkit.Bukkit.createInventory(null, raw*9, display);
    }
    /**
     * Abbreviate and add plugin commands.
     * Use when it's a hassle.
     * @param cmd command name
     * @param executor CommandExecutor w/ TabCompleter
     */
    public static void a(String cmd, org.bukkit.command.CommandExecutor executor){
        org.bukkit.Bukkit.getPluginCommand(cmd).setExecutor(executor);
    }
    /**
     * Convert arraylist to array
     * @param a Object Arraylist
     * @return Object[] array
     */
    public static Object[] a(java.util.ArrayList<Object> a){
        return a.toArray(new Object[a.size()]);
    }
    /**
     * Read the contents of the file one line at a time and return them in a list.
     * @param dir Path to Directory
     * @param name File name
     * @return StringList
     */
    public static java.util.ArrayList<String> a(String dir, String name){
        java.util.ArrayList<String> l = new java.util.ArrayList<String>();
        try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(new java.io.File(dir, name)))){
            String line; while((line = in.readLine()) != null) l.add(line);
        } catch (java.io.IOException e) { e.printStackTrace(); }
        return l;
    }
    /**
     * Read the contents of the file one line at a time and return them in a list.
     * @param f target file
     * @return StringList
     */
    public static java.util.ArrayList<String> a(java.io.File f){
        java.util.ArrayList<String> l = new java.util.ArrayList<String>();
        try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(f))){
            String line; while((line = in.readLine()) != null) l.add(line);
        } catch (java.io.IOException e) { e.printStackTrace(); }
        return l;
    }
    /**
     * Return one of the contents of the list at random.
     * @param list List (req size 0 < )
     * @return element
     */
    public static Object a(java.util.List<Object> list){
        return list.get(new java.util.Random().nextInt(list.size()));
    }
    /**
     * Converts to Morse code and returns a string.
     * @param a base string (req english w/ uppercase)
     * @return convert morse code string
     */
    public static String a(String a){
        return a.replaceAll("A", "・－")
                .replaceAll("B", "－・・・")
                .replaceAll("C", "－・－・")
                .replaceAll("D", "－・・")
                .replaceAll("E", "・")
                .replaceAll("F", "・・－・")
                .replaceAll("G", "－－・")
                .replaceAll("H", "・・・・")
                .replaceAll("I", "・・")
                .replaceAll("J", "・－－－")
                .replaceAll("K", "－・－")
                .replaceAll("L", "・－・・")
                .replaceAll("M", "－－")
                .replaceAll("N", "－・")
                .replaceAll("O", "－－－")
                .replaceAll("P", "・－－・")
                .replaceAll("Q", "－－・－")
                .replaceAll("R", "・－・")
                .replaceAll("S", "・・・")
                .replaceAll("T", "－")
                .replaceAll("U", "・・－")
                .replaceAll("V", "・・・－")
                .replaceAll("W", "・－－")
                .replaceAll("X", "－・・－")
                .replaceAll("Y", "－・－－")
                .replaceAll("Z", "－－・・");
    }
    /**
     * Get the blocks under your feet.
     * @param p target player
     * @return feet block
     */
    public static org.bukkit.block.Block a(org.bukkit.entity.Player p){
        return p.getLocation().getBlock().getRelative(org.bukkit.block.BlockFace.DOWN);
    }
}
