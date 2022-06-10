package File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProfitsFile {

	public static File file = new File("plugins/CaseOpener/", "Profits.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static void saveFile() {	
		try {
			cfg.save(file);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void loadFile() {
		List t1 = cfg.getStringList("Profits.Tier 1.Profits");
		t1.add("4:0, 64, 25, &7Cobblestone, DIG_SPEED, 1, KNOCKBACK, 1");
		t1.add("263:0, 64, 15, &1Coal");
		t1.add("287:0, 64, 15, &1String");
		t1.add("351:1, 32, 10, &1Red Dye");
		t1.add("15:0, 20, 10, &1Iron Ore");
		t1.add("300:0, 1, 9, &dLeather Leggings");
		t1.add("303:0, 1, 5, &4Chainmail Chestplate");
		t1.add("264:0, 1, 1, &6Diamond");
		cfg.addDefault("Profits.Tier 1.Profits", t1);
		
		List t2 = cfg.getStringList("Profits.Tier 2.Profits");
		t2.add("4:0, 64, 25, &7Cobblestone");
		t2.add("12:0, 64, 15, &1Sand");
		t2.add("364:0, 20, 10, &1Steak");
		t2.add("15:0, 40, 15, &1Iron Ore");
		t2.add("331:0, 32, 10, &1Redstone");
		t2.add("14:0, 16, 10, &5Gold Ore");
		t2.add("317:0, 1, 9, &dGold Boots");
		t2.add("307:0, 1, 5, &4Iron Chestplate");
		t2.add("276:0, 1, 1, &6Diamond Sword");
		cfg.addDefault("Profits.Tier 2.Profits", t2);
		
		List t3 = cfg.getStringList("Profits.Tier 3.Profits");
		t3.add("338:0, 64, 25, &1Sugarcane");
		t3.add("334:0, 64, 15, &1Leather");
		t3.add("261:0, 1, 10, &1Bow");
		t3.add("267:0, 1, 15, &1Iron Sword");
		t3.add("351:4, 32, 10, &1Blue Dye");
		t3.add("378:0, 16, 10, &5Magma Cream");
		t3.add("130:0, 1, 9, &dEnder Chest");
		t3.add("312:0, 1, 5, &4Diamond Leggings");
		t3.add("278:0, 1, 1, &6Diamond Pickaxe");
		cfg.addDefault("Profits.Tier 3.Profits", t3);
		
		List t4 = cfg.getStringList("Profits.Tier 4.Profits");
		t4.add("265:0, 64, 25, &1Iron Ingot");
		t4.add("266:0, 64, 15, &1Gold Ingot");
		t4.add("369:0, 20, 15, &1Blaze Rod");
		t4.add("322:0, 20, 10, &1Golden Apple");
		t4.add("312:0, 1, 9, &dDiamond Leggings");
		t4.add("311:0, 1, 5, &4Diamond Chestplate");
		cfg.addDefault("Profits.Tier 4.Profits", t4);
		
		List t5 = cfg.getStringList("Profits.Tier 5.Profits");
		t5.add("384:0, 64, 25, &1Experience Bottle");
		t5.add("370:0, 64, 15, &1Ghast Tear");
		t5.add("261:0, 1, 15, &1Bow");
		t5.add("278:0, 1, 10, &1Diamond Pickaxe");
		t5.add("276:0, 1, 10, &5Diamond Sword");
		t5.add("312:0, 1, 10, &dDiamond Leggings");
		t5.add("311:0, 1, 9, &4Diamond Chestplate");
		t5.add("322:1, 1, 1, &2Golden Apple");
		cfg.addDefault("Profits.Tier 5.Profits", t5);
		cfg.options().copyDefaults(true);
		saveFile();
	}
}
