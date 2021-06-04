package net.kunmc.lab.artforest;

import org.bukkit.Sound;

public class Kei {
    private static class cc {
        private static org.bukkit.ChatColor red = org.bukkit.ChatColor.RED;
        private static org.bukkit.ChatColor black = org.bukkit.ChatColor.BLACK;
        private static org.bukkit.ChatColor blue = org.bukkit.ChatColor.BLUE;
        private static org.bukkit.ChatColor yellow = org.bukkit.ChatColor.YELLOW;
        private static org.bukkit.ChatColor pink = org.bukkit.ChatColor.LIGHT_PURPLE;
        private static org.bukkit.ChatColor purple = org.bukkit.ChatColor.DARK_PURPLE;
        private static org.bukkit.ChatColor lime = org.bukkit.ChatColor.GREEN;
        private static org.bukkit.ChatColor green = org.bukkit.ChatColor.DARK_GREEN;
        private static org.bukkit.ChatColor aqua = org.bukkit.ChatColor.AQUA;
        private static org.bukkit.ChatColor bold = org.bukkit.ChatColor.BOLD;
        private static org.bukkit.ChatColor graydark = org.bukkit.ChatColor.DARK_GRAY;
        private static org.bukkit.ChatColor gray = org.bukkit.ChatColor.GRAY;
        private static org.bukkit.ChatColor gold = org.bukkit.ChatColor.GOLD;
        private static org.bukkit.ChatColor white = org.bukkit.ChatColor.WHITE;
        private static org.bukkit.ChatColor italic = org.bukkit.ChatColor.ITALIC;
        private static org.bukkit.ChatColor strike = org.bukkit.ChatColor.STRIKETHROUGH;
        private static org.bukkit.ChatColor under = org.bukkit.ChatColor.UNDERLINE;
        private static org.bukkit.ChatColor bluedark = org.bukkit.ChatColor.DARK_BLUE;
        private static org.bukkit.ChatColor reddark = org.bukkit.ChatColor.DARK_RED;
        private static org.bukkit.ChatColor magic = org.bukkit.ChatColor.MAGIC;
    }

    private static class gm {
        private static org.bukkit.GameMode g0 = org.bukkit.GameMode.SURVIVAL;
        private static org.bukkit.GameMode g1 = org.bukkit.GameMode.CREATIVE;
        private static org.bukkit.GameMode g2 = org.bukkit.GameMode.ADVENTURE;
        private static org.bukkit.GameMode g3 = org.bukkit.GameMode.SPECTATOR;
        private static org.bukkit.GameMode survival = org.bukkit.GameMode.SURVIVAL;
        private static org.bukkit.GameMode creative = org.bukkit.GameMode.CREATIVE;
        private static org.bukkit.GameMode adventure = org.bukkit.GameMode.ADVENTURE;
        private static org.bukkit.GameMode spectator = org.bukkit.GameMode.SPECTATOR;
    }

    private static class dyecolor {
        private static org.bukkit.DyeColor red = org.bukkit.DyeColor.RED;
        private static org.bukkit.DyeColor black = org.bukkit.DyeColor.BLACK;
        private static org.bukkit.DyeColor blue = org.bukkit.DyeColor.BLUE;
        private static org.bukkit.DyeColor yellow = org.bukkit.DyeColor.YELLOW;
        private static org.bukkit.DyeColor brown = org.bukkit.DyeColor.BROWN;
        private static org.bukkit.DyeColor cyan = org.bukkit.DyeColor.CYAN;
        private static org.bukkit.DyeColor green = org.bukkit.DyeColor.GREEN;
        private static org.bukkit.DyeColor lime = org.bukkit.DyeColor.LIME;
        private static org.bukkit.DyeColor orange = org.bukkit.DyeColor.ORANGE;
        private static org.bukkit.DyeColor magenta = org.bukkit.DyeColor.MAGENTA;
        private static org.bukkit.DyeColor gray = org.bukkit.DyeColor.GRAY;
        private static org.bukkit.DyeColor bluelight = org.bukkit.DyeColor.LIGHT_BLUE;
        private static org.bukkit.DyeColor graylight = org.bukkit.DyeColor.LIGHT_GRAY;
        private static org.bukkit.DyeColor pink = org.bukkit.DyeColor.PINK;
        private static org.bukkit.DyeColor white = org.bukkit.DyeColor.WHITE;
        private static org.bukkit.DyeColor purple = org.bukkit.DyeColor.PURPLE;
    }

    private static class dyematerial {
        private static org.bukkit.Material black = org.bukkit.Material.INK_SAC;
        private static org.bukkit.Material red = org.bukkit.Material.RED_DYE;
        private static org.bukkit.Material blue = org.bukkit.Material.BLUE_DYE;
        private static org.bukkit.Material yellow = org.bukkit.Material.YELLOW_DYE;
        private static org.bukkit.Material brown = org.bukkit.Material.BROWN_DYE;
        private static org.bukkit.Material cyan = org.bukkit.Material.CYAN_DYE;
        private static org.bukkit.Material green = org.bukkit.Material.GREEN_DYE;
        private static org.bukkit.Material lime = org.bukkit.Material.LIME_DYE;
        private static org.bukkit.Material orange = org.bukkit.Material.ORANGE_DYE;
        private static org.bukkit.Material magenta = org.bukkit.Material.MAGENTA_DYE;
        private static org.bukkit.Material gray = org.bukkit.Material.GRAY_DYE;
        private static org.bukkit.Material bluelight = org.bukkit.Material.LIGHT_BLUE_DYE;
        private static org.bukkit.Material graylight = org.bukkit.Material.LIGHT_GRAY_DYE;
        private static org.bukkit.Material pink = org.bukkit.Material.PINK_DYE;
        private static org.bukkit.Material white = org.bukkit.Material.WHITE_DYE;
        private static org.bukkit.Material purple = org.bukkit.Material.PURPLE_DYE;
    }
    private static class sound {
        private void levelup(org.bukkit.entity.Player p, int vol){p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, vol, 0f);}
    }
    /**
     * Ez itemstack gen
     * @param m material
     */
    public static org.bukkit.inventory.ItemStack i(org.bukkit.Material m) {
        return new org.bukkit.inventory.ItemStack(m);
    }
    /**
     * Ez give
     * @param p player
     * @param i item
     */
    public static void give(org.bukkit.entity.Player p, org.bukkit.inventory.ItemStack i) {
        p.getInventory().addItem(i);
    }
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
    public static org.bukkit.entity.Player a(java.util.List<org.bukkit.entity.Player> list){
        return list.get(new java.util.Random().nextInt(list.size()));
    }
    /**
     * Converts to Morse code and returns a string.
     * @param a base string (req english w/ uppercase)
     * @return convert morse code string
     */
    public static String a(String a) {
        String r = a.toUpperCase();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < r.length(); i++) {
            char code = r.charAt(i);
            if ((code >= 0x3041) && (code <= 0x3093)) {
                buf.append((char) (code + 0x60));
            } else {
                buf.append(code);
            }
        }
        r = buf.toString();
        return r.replaceAll("A", "・－")
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
                .replaceAll("Z", "－－・・")
                .replaceAll("1",  "・－－－－")
                .replaceAll("2", "・・－－－")
                .replaceAll("3", "・・・－－")
                .replaceAll("4", "・・・・－")
                .replaceAll("5", "・・・・・")
                .replaceAll("6", "－・・・・")
                .replaceAll("7", "－－・・・")
                .replaceAll("8", "－－－・・")
                .replaceAll("9", "－－－－・")
                .replaceAll("0", "－－－－－")
                .replaceAll("\\.", "・－・－・－")
                .replaceAll(",", "－－・・－－")
                .replaceAll(":", "－－－・・・")
                .replaceAll("\\?", "・・－－・・")
                .replaceAll("？", "・・－－・・")
                .replaceAll("’", "・－－－－・")
                .replaceAll("-", "－・・・・－")
                .replaceAll("ー", "－・・・・－")
                .replaceAll("\\(", "－・－－・")
                .replaceAll("（", "－・－－・")
                .replaceAll("\\)", "－・－－・－")
                .replaceAll("）", "－・－－・－")
                .replaceAll("/", "－・・－・")
                .replaceAll("／", "－・・－・")
                .replaceAll("=", "－・・・－")
                .replaceAll("＝", "－・・・－")
                .replaceAll("\\+", "・－・－・")
                .replaceAll("＋", "・－・－・")
                .replaceAll("\"", "・－・・－・")
                .replaceAll("\\*", "－・・－")
                .replaceAll("@", "・－－・－・")
                .replaceAll("＠", "・－－・－・")
                .replaceAll("ア", "－－・－－")
                .replaceAll("イ", "・－")
                .replaceAll("ウ", "・・－")
                .replaceAll("エ", "－・－－－")
                .replaceAll("オ", "・－・・・")
                .replaceAll("カ", "・－・・")
                .replaceAll("キ", "－・－・・")
                .replaceAll("ク", "・・・－")
                .replaceAll("ケ", "－・－－")
                .replaceAll("コ", "－－－－")
                .replaceAll("サ", "－・－・－")
                .replaceAll("シ", "－－・－・")
                .replaceAll("ス", "－－－・－")
                .replaceAll("セ", "・－－－・")
                .replaceAll("ソ", "－－－・")
                .replaceAll("タ", "－・")
                .replaceAll("チ", "・・－・")
                .replaceAll("ツ", "・－－・")
                .replaceAll("テ", "・－・－－")
                .replaceAll("ト", "・・－・・")
                .replaceAll("ナ","・－・")
                .replaceAll("ニ", "－・－・")
                .replaceAll("ヌ", "・・・・")
                .replaceAll("ネ", "－－・－")
                .replaceAll("ノ", "・・－－")
                .replaceAll("ハ", "－・・・")
                .replaceAll("ヒ", "－－・・－")
                .replaceAll("フ", "－－・・")
                .replaceAll("ヘ", "・")
                .replaceAll("ホ", "－・・")
                .replaceAll("マ", "－・・－")
                .replaceAll("ミ", "・・－・－")
                .replaceAll("ム", "－")
                .replaceAll("メ", "－・・・－")
                .replaceAll("モ", "－・・－・")
                .replaceAll("ヤ", "・－－")
                .replaceAll("ユ", "－・・－－")
                .replaceAll("ヨ", "－－")
                .replaceAll("ラ", "・・・")
                .replaceAll("リ", "－－・")
                .replaceAll("ル", "－・－－・")
                .replaceAll("レ", "－－－")
                .replaceAll("ロ", "・－・－")
                .replaceAll("ワ", "－・－")
                .replaceAll("ヰ", "・－・・－")
                .replaceAll("ヲ", "・－－－")
                .replaceAll("ヱ", "・－－・・")
                .replaceAll("ン", "・－・－・");
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