package classes;

import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import CaseOpener.Main;
import java.util.*;

public class CaseAPI implements Listener {

    static Main pl;
    public CaseAPI(Main main) {
        CaseAPI.pl = main;}
    private static HashMap<Player, Integer> taskID = new HashMap<>();
    private static int timer = 0;
    public static void openCase(Player p, int tier) {
        Inventory inv = Bukkit.createInventory(p, 27, pl.getConfig().getString("Names.Tier " + tier + " Case.Name").replace("&", "§"));
        List<ItemStack> items = new ArrayList<>();
        Random r1 = new Random();
        Random r2 = new Random();
        ConfigurationSection casekeycontent = pl.cg.getConfigurationSection("DROPS.Tier " + tier);
        for (String casekey : casekeycontent.getKeys(false)) {
                Material ID = Material.AIR;
                int subID = 0;
                int maxamount = 0;
                int chance = 0;
                String name = "";
                String ench = "";
                int enchlvl = 0;
                String nameofids =  pl.cg.getString("DROPS.Tier "+ tier+"." + casekey + ".id");
                //String[] array = nameofids.split(":");
                ID = Material.getMaterial(nameofids, false);
                //String a = array[1];
                //a = a.substring(0, 1);
                //subID = Integer.parseInt(a);
                maxamount = pl.cg.getInt("DROPS.Tier " + tier+"." + casekey + ".amount");
                chance = pl.cg.getInt("DROPS.Tier " + tier+"." + casekey + ".chance");
                name = pl.cg.getString("DROPS.Tier " + tier+"." + casekey + ".name").replace("&", "§");
                boolean uzywaench = pl.cg.getBoolean("DROPS.Tier "+ tier+"." + casekey + ".usingench");
                for (int i = 0; i < chance; i++) {
                        ItemStack is = new ItemStack(ID, getRandomInteger(maxamount) + 1);
                        ItemMeta im = is.getItemMeta();
                        im.setDisplayName(name);
                        is.setItemMeta(im);
                if(uzywaench){
                    ConfigurationSection enof = pl.cg.getConfigurationSection( "DROPS.Tier " + tier+"." + casekey + ".ench");
                    for (String enchnameofpizda : enof.getKeys(false)) {
                    if (pl.cg.getString("DROPS.Tier " + tier + "." + casekey + ".ench") != null) {
                        is.addUnsafeEnchantment(Enchantment.getByName(enchnameofpizda), pl.cg.getInt("DROPS.Tier " + tier + "." + casekey + ".ench." + enchnameofpizda));
                    }
                }
                       }
                        items.add(is);
                }
        }
        for(int i = 10; i < 17; i++) {
            int n1 = r1.nextInt(items.size());
            inv.setItem(i, items.get(n1));
        }
            Material cent = Material.valueOf(pl.getConfig().getString("CASE_GLASS_COLOR_CENTER"));
            Material around = Material.valueOf(pl.getConfig().getString("CASE_GLASS_COLOR"));
            inv.setItem(22, newItem(Material.ORANGE_STAINED_GLASS_PANE, 1, "§6⬆"));
            inv.setItem(4, newItem(Material.ORANGE_STAINED_GLASS_PANE, 1, "§6⬇"));
            inv.setItem(0, newItem(cent, 1,  "§r"));
            inv.setItem(1, newItem(cent, 1,  "§r"));
            inv.setItem(2, newItem(around, 1,  "§r"));
            inv.setItem(3, newItem(around, 1,  "§r"));
            inv.setItem(5, newItem(around, 1,  "§6r"));
            inv.setItem(6, newItem(around, 1,  "§6r"));
            inv.setItem(7, newItem(around, 1,  "§6r"));
            inv.setItem(8, newItem(around, 1,  "§6r"));
            inv.setItem(9, newItem(around, 1,  "§6r"));
            inv.setItem(17, newItem(around, 1,  "§6r"));
            inv.setItem(18, newItem(around, 1,  "§6r"));
            inv.setItem(19, newItem(around, 1,  "§6r"));
            inv.setItem(20, newItem(around, 1,  "§6r"));
            inv.setItem(21, newItem(around, 1,  "§6r"));
            inv.setItem(23, newItem(around, 1,  "§6r"));
            inv.setItem(24, newItem(around, 1,  "§6r"));
            inv.setItem(25, newItem(around, 1,  "§6r"));
            inv.setItem(26, newItem(around, 1,  "§6r"));

        int tid = 0;
        tid = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
            @Override
            public void run() {
                timer++;
                int n2 = r2.nextInt(items.size());
                inv.setItem(10, inv.getItem(11));
                inv.setItem(11, inv.getItem(12));
                inv.setItem(12, inv.getItem(13));
                inv.setItem(13, inv.getItem(14));
                inv.setItem(14, inv.getItem(15));
                inv.setItem(15, inv.getItem(16));
                inv.setItem(16, items.get(n2));

                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                if (timer == 50) {
                    stopRolling(p);
                    timer = 0;

                    Map<Enchantment, Integer> item = inv.getItem(13).getEnchantments();
                    ItemStack is = new ItemStack(inv.getItem(13).getType(), inv.getItem(13).getAmount(), inv.getItem(13).getDurability());
                    ItemMeta ism = is.getItemMeta();
                    ism.setDisplayName(inv.getItem(13).getItemMeta().getDisplayName());
                    List<String> loreis = new ArrayList<>();
                    String lore1 = pl.getConfig().getString("DROPED_FROM").replace("&", "§");
                    String clore1 = ChatColor.translateAlternateColorCodes('&', lore1);
                    loreis.add(0, clore1 + pl.getConfig().getString("Names.Tier " + tier + " Case.Name").replace("&", "§"));
                    ism.setLore(loreis);
                    is.setItemMeta(ism);
                    if (inv.getItem(13).getItemMeta().hasEnchants()) {
                        is.addEnchantments(item);
                    }
                    p.getInventory().addItem(is);
                    p.sendMessage(pl.getConfig().getString("WON_TEXT").replace("&", "§") + ism.getDisplayName() + " x"+ is.getAmount());
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 1, 1);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                        @Override
                        public void run() {
                            p.closeInventory();
                        }

                    }, 50);

                }
            }
        }, 0, 2);
        taskID.put(p, tid);
        p.openInventory(inv);
    }
    @EventHandler
    void RemoveBukkitR(InventoryCloseEvent e) {
        if(e.getView().getTitle().equals(pl.getConfig().getString("Names.Tier 1 Case.Name").replace("&", "§"))) {
            Player p = (Player) e.getPlayer();
            if(taskID.containsKey(p)) {
                int ids = taskID.get(p);
                pl.getServer().getScheduler().cancelTask(ids);
                taskID.remove(p);
                p.sendMessage(pl.getConfig().getString("WARNING_CLOSE_CASE").replace("&", "§"));
            }
        }
    }

    public static void stopRolling(Player p) {
        if(taskID.containsKey(p)) {
            int tid = taskID.get(p);
            pl.getServer().getScheduler().cancelTask(tid);
            taskID.remove(p);
        }

    }
    public static ItemStack newItem(Material mat, int amount, String name, String[][] enchantments) {
        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(mat, amount);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        for (int i = 0; i < enchantments.length; i++) {
            if(enchantments[i][0] != null) {
                for(Enchantment e : Enchantment.values()) {
                    if(e.getName().equals(enchantments[i][0])) {
                        im.addEnchant(e, Integer.parseInt(enchantments[i][1]), true);
                    }
                }
            }
        }
        is.setItemMeta(im);
        return is;
    }
    public static ItemStack newItem(Material mat, int amount, String name, String enchantment, int enchantmentLvl, String lore) {
        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(mat, amount);
        ItemMeta im = is.getItemMeta();
        ArrayList<String> Lore = new ArrayList<>();
        Lore.add(lore);
        im.setDisplayName(name);
        im.setLore(Lore);
        is.setItemMeta(im);
        is.addEnchantment(Enchantment.getByKey(NamespacedKey.minecraft(enchantment)), enchantmentLvl);
        return is;
    }
    public static ItemStack newItem(Material mat, int amount, String enchantment, int enchantmentLvl) {
        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(mat, amount);
        is.addEnchantment(Enchantment.getByKey(NamespacedKey.minecraft(enchantment)), enchantmentLvl);
        return is;
    }
    public static ItemStack newItem(Material mat, int amount, String name, String lore) {
        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(mat, amount);
        ItemMeta im = is.getItemMeta();
        ArrayList<String> Lore = new ArrayList<>();
        Lore.add(lore);
        im.setDisplayName(name);
        im.setLore(Lore);
        is.setItemMeta(im);
        return is;
    }
    public static ItemStack newItem(Material mat, int amount, String name) {
        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(mat, amount);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return is;
    }
    public static ItemStack newItem(Material mat, int amount) {
        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(mat, amount);
        return is;
    }
    public static ItemStack newItem(Material mat, String name) {
        ItemStack is = new ItemStack(mat);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return is;
    }
    public static int getRandomInteger(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }
}


