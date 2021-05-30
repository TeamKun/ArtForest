package net.kunmc.lab.artforest;
public class Kei {
    /**
     * Ez sender send message
     * @param p target player
     * @param s messages
     */
    public static void psm(org.bukkit.entity.Player p, String... s) {
        java.util.Arrays.stream(s).forEach(p::sendMessage);
    }
    /**
     * clear inventory items
     * @param p target player
     * @param armor with armor
     */
    public static void cinv(org.bukkit.entity.Player p, boolean armor) {
        try {  if (armor) { java.util.Arrays.stream(p.getInventory().getContents()).forEach(i -> i.setType(org.bukkit.Material.AIR));
            } else { java.util.Arrays.stream(p.getInventory().getArmorContents()).forEach(i -> i.setType(org.bukkit.Material.AIR)); }
        } catch (java.lang.Exception ignored){}
    }
    /**
     * Random pick a online player
     * @return pick an online player
     */
    public static org.bukkit.entity.Player p1p() {
        return (org.bukkit.entity.Player) org.bukkit.Bukkit.getOnlinePlayers().toArray()[new java.util.Random().nextInt(org.bukkit.Bukkit.getOnlinePlayers().size())];
    }
    /**
     * Ez sender op check
     * @param sender CommandSender
     * @return op = true, not op = false
     */
    public static boolean pexc(org.bukkit.command.CommandSender sender) {
        if(!sender.isOp()){
            sender.sendMessage(org.bukkit.ChatColor.RED + "権限がありません。");
            return true;
        } else {
            return false;
        }
    }
    /**
     * Ez sender send message
     * @param sender CommandSender
     * @param str message
     */
    public static void sm(org.bukkit.command.CommandSender sender, String... str) {
        java.util.Arrays.stream(str).forEach(sender::sendMessage);
    }
    /**
     * Ez broadcast message
     * @param str messages
     */
    public static void bc(String... str){
        java.util.Arrays.stream(str).forEach(org.bukkit.Bukkit::broadcastMessage);
    }
    /**
     * Ez broadcast actionbar message
     * @param str messages
     */
    public static void bac(String str){
        org.bukkit.Bukkit.getOnlinePlayers().forEach(p -> p.sendActionBar(str));
    }
    /**
     * Ez args length check
     * @param args command args
     * @param lim limit elements
     * @return true = length < lim
     */
    public static boolean agc(String[] args, int lim){
        return args.length < lim;
    }
    /**
     * Ez args element check
     * @param args command args
     * @param lim elements id
     * @param cmd cmd name
     * @return string equals
     */
    public static boolean agc(String[] args, int lim, String cmd){
        return !agc(args, lim+1) && args[lim].equalsIgnoreCase(cmd);
    }
    /**
     * Ez clear inventory
     * @param p target player
     */
    public static void cinv(org.bukkit.entity.Player p) {
        try{ org.bukkit.inventory.PlayerInventory inv = p.getInventory(); inv.clear(); java.util.Arrays.stream(inv.getArmorContents()).forEach(i -> i.setType(org.bukkit.Material.AIR));
        } catch (java.lang.Exception ignored){}
    }
    /**
     * System.out.println(str);
     * @param str
     */
    public static void out(Object str){
        System.out.println(str);
    }
    /**
     * System.out.println(str);
     * @param str some obj
     */
    public static void out(Object... str){
        java.util.Arrays.stream(str).forEach(System.out::println);
    }
    /**
     * check player gamemode
     * @param g target gamemode
     * @param p player entity
     * @return true = match
     */
    public static boolean a(org.bukkit.GameMode g, org.bukkit.entity.Player p){
        return p.getGameMode() == g;
    }
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
     * register listener
     * Use when it's a hassle.
     * @param listener command name
     * @param plugin Javaplugin
     */
    public static void a(org.bukkit.event.Listener listener, org.bukkit.plugin.java.JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
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
    /**
     * Set gamemode some players.
     * @param players target players.
     * @param gm gamemode.
     */
    public static void a(java.util.List<org.bukkit.entity.Player> players, org.bukkit.GameMode gm){
        players.forEach(p -> p.setGameMode(gm));
    }
    /**
     * Set gamemode a players.
     * @param p target players.
     * @param gm gamemode.
     */
    public static void a(org.bukkit.entity.Player p, org.bukkit.GameMode gm){
        p.setGameMode(gm);
    }
    /**
     * Set gamemode with async
     * @param p target players.
     * @param gm gamemode.
     * @param bool async
     */
    public static void a(org.bukkit.entity.Player p, org.bukkit.GameMode gm, boolean bool, org.bukkit.plugin.java.JavaPlugin plugin){
        if(bool){
            new org.bukkit.scheduler.BukkitRunnable() {
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
                    p.setGameMode(gm);
                }
            }.runTaskLater(plugin, 1);
        } else {
            p.setGameMode(gm);
        }
    }
    /**
     * get gamemode a player.
     * @param p target players.
     * @return player gamemode
     */
    public static org.bukkit.GameMode gm(org.bukkit.entity.Player p) {
        return p.getGameMode();
    }
    /**
     * return manatsu no yoruno inmu ASCII string list
     * @return string list
     */
    public static java.util.List<String> manatu810(){
        return java.util.Arrays.asList(
                "　　　　　__　　　　　　　　　　　　　　 「.|＿_\n" +
                        "　　 ┌ ┘ト ┐　　　　　　　　　┌'￣　＿ ］ ,'￣｀l 　　　,-─--､\n" +
                        "　　　´ﾆｺ ｆﾆ｀ ,,──-- ､　　　 _フ l フ-､　,'/| |ヽ|　,‐┐l n .n ｔ'　　 _　 _\n" +
                        "　　　 | ｆﾆｺ |　　ﾆl l二ﾞｰ'　　　/_┌く /］/　||.∥ .||　￣　|.| |.| |.|　 ,_」 |_| |＿\n" +
                        "　　　 | ｆﾆｺ |　　| ｆﾆｺ |　,-ー‐､ |.|　ヽ''/　 ||∥　l l /ﾆﾌ」 \"　\" ］ └_､.=┌ '\n" +
                        "　　　 | ｆﾆｺ |　　| ｆﾆｺ | //l 「ヽ| |.|　/,ﾍ＼ヽ/　.ﾉ |　　,,,'二l l二_　 | fl fl fl |\n" +
                        "　　＿ﾆ二ﾆ--､ | ｆﾆｺ | || ∥　|| |.|ヽ/　＼ヽ,　 \"\"　,-'/l,-┐,- ､|　ヽ──‐'_\n" +
                        "　└┐┌┐┌'　ﾌくﾌ「 .||∥　 |.|.l/　　　　｀´　　　　 \"　＿」.L___ 「二二二ﾆ　］\n" +
                        "　 　 |___|　|__| ／/> く　.|∥　//　　　　　　　　　　　　　ヽ─‐‐┘|」/二ﾆ ﾌ | |\n" +
                        "　　　　　　　 └／ ヘ＼ヽ'　'''　　　　　　　　　　　　　　　　　　　　/_|<ヽ'/　|/\n" +
                        "　　　　　　　　　V´　 ＼_フ　　　　　　　　　　　　　　　　　　　　　 ,､／／\n" +
                        "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　 ヽ／　 ,、"
        );
    }
    /**
     * send title a player.
     * @param p player
     * @param main main title
     * @param sub subtitle
     */
    public static void t(org.bukkit.entity.Player p, String main, String sub){
        p.sendTitle(main, sub, 1, 20, 1);
    }
    /**
     * send title a player.
     * @param p player
     * @param main main title
     * @param sub subtitle
     * @param fadein fadein
     */
    public static void t(org.bukkit.entity.Player p, String main, String sub, int fadein){
        p.sendTitle(main, sub, fadein, 20, 1);
    }
    /**
     * send title a player.
     * @param p player
     * @param main main title
     * @param sub subtitle
     * @param fadein fadein
     * @param stay stay
     */
    public static void t(org.bukkit.entity.Player p, String main, String sub, int fadein, int stay){
        p.sendTitle(main, sub, fadein, stay, 1);
    }
    /**
     * send title a player.
     * @param p player
     * @param main main title
     * @param sub subtitle
     * @param fadein fadein
     * @param stay stay
     * @param fadeout
     */
    public static void t(org.bukkit.entity.Player p, String main, String sub, int fadein, int stay, int fadeout){
        p.sendTitle(main, sub, fadein, stay, fadeout);
    }
    /**
     * first setup
     */
    public static void z(org.bukkit.plugin.java.JavaPlugin j) {
        j.saveDefaultConfig();
    }
}
