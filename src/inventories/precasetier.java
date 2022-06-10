package inventories;

import CaseOpener.Main;
import classes.CaseAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class precasetier implements Listener {
    static Main pl;


public precasetier(Main plugin) {
        pl = plugin;
    }
    public static void openprecasetier(Player p, int tier) {
        Inventory precasetier = Bukkit.createInventory(p, 54, (pl.getConfig().getString("Names.Tier " + tier + " Case.Name").replace("&", "§")+ " - preview"));

        ItemStack placeholder = new ItemStack(Material.valueOf(pl.getConfig().getString("PRECASE_GLASS_COLOR_CONTENT")) , 1);
        ItemStack placeholdertop = new ItemStack(Material.valueOf(pl.getConfig().getString("PRECASE_GLASS_COLOR_TOP")), 1);
        ItemStack placeholderbottom = new ItemStack(Material.valueOf(pl.getConfig().getString("PRECASE_GLASS_COLOR_BOTTOM")), 1);

        ItemMeta placeholderim = placeholder.getItemMeta();
        placeholderim.setDisplayName(" ");
        placeholder.setItemMeta(placeholderim);

        ItemMeta placeholderim1 = placeholdertop.getItemMeta();
        placeholderim1.setDisplayName(" ");
        placeholdertop.setItemMeta(placeholderim1);

        ItemMeta placeholderim2 = placeholderbottom.getItemMeta();
        placeholderim2.setDisplayName(" ");
        placeholderbottom.setItemMeta(placeholderim2);
        List<ItemStack> items = new ArrayList<>();
        ConfigurationSection casekeycontent = pl.cg.getConfigurationSection("DROPS.Tier " + tier);
        for (int i = 9; i < 45; i++) {
            precasetier.setItem(i, placeholder);
        }
        for (int i = 0; i < 9; i++) {
            precasetier.setItem(i,placeholdertop);
        }
        for (int i = 45; i < 54; i++) {
            precasetier.setItem(i,placeholderbottom);
        }
            if(casekeycontent == null) {
                p.sendMessage(pl.getConfig().getString("WARNING_NO_CASE_CONTENT").replace("&", "§"));
                p.closeInventory();
                return;
            }
        for (String casekey : casekeycontent.getKeys(false)) {
            Material ID;
            int subID = 0;
            int maxamount = 0;
            int chance = 0;
            String name = "";
            String ench = "";
            int enchlvl = 0;
            String nameofids =  pl.cg.getString("DROPS.Tier "+ tier+"." + casekey + ".id");
            //[] array = nameofids.split(":");
            ID = Material.valueOf(nameofids);
            //p.sendMessage(String.valueOf(ID));
            //p.sendMessage(nameofids);
            //String a = array[1];
            //a = a.substring(0, 1);
            //subID = Integer.parseInt(a);
            maxamount = pl.cg.getInt("DROPS.Tier " + tier+"." + casekey + ".amount");

            name = pl.cg.getString("DROPS.Tier " + tier+"." + casekey + ".name").replace("&", "§");
            boolean uzywaench = pl.cg.getBoolean("DROPS.Tier "+ tier+"." + casekey + ".usingench");
            if(ID == null) return;
            ItemStack is = new ItemStack(ID,  1);
                ItemMeta im = is.getItemMeta();
                im.setDisplayName(name);
                is.setItemMeta(im);
                if(uzywaench == true){
                    ConfigurationSection enof = pl.cg.getConfigurationSection( "DROPS.Tier " + tier+"." + casekey + ".ench");
                    for (String enchnameofpizda : enof.getKeys(false)) {
                        if (pl.cg.getString("DROPS.Tier " + tier + "." + casekey + ".ench") != null) {
                            is.addUnsafeEnchantment(Enchantment.getByName(enchnameofpizda) , pl.cg.getInt("DROPS.Tier " + tier + "." + casekey + ".ench." + enchnameofpizda));
                        }
                    }
                }
                items.add(is);
            }


        for (int j = 9; j < items.size() + 9; j++) {
                precasetier.setItem(j, items.get(j - 9));


        }

        precasetier.setItem(47, CaseAPI.newItem(Material.TRIPWIRE_HOOK, 1, pl.getConfig().getString("OPEN_CASE").replace("&", "§")));
        precasetier.setItem(51, CaseAPI.newItem(Material.BARRIER, 1, pl.getConfig().getString("CLOSE_CASE").replace("&", "§")));
        p.openInventory(precasetier);

    }
}



