package CaseOpener;

import classes.CaseAPI;
import comands.Case_Command;
import inventories.precasetier;
import listener.playersevents;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
	CaseAPI capi = new CaseAPI(this);
	precasetier prect = new precasetier(this);
	playersevents plE = new playersevents(this);
	public File file = new File(getDataFolder(), "items.yml");
	public FileConfiguration cg = YamlConfiguration.loadConfiguration(file);


	void saveFile() {
		try {
			cg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onEnable() {

		getLogger().info("=======================");
		getLogger().info("                       ");
		getLogger().info("[CaseOpener] ENABLED   ");
		getLogger().info("                       ");
		getLogger().info("=======================");
		Bukkit.getPluginManager().registerEvents(prect, this);
		Bukkit.getPluginManager().registerEvents(capi, this);
		Bukkit.getPluginManager().registerEvents(plE,this);
		this.getCommand("case").setExecutor(new Case_Command(this));
		saveDefaultConfig();
		saveFile();

	}
	@Override
	public void onDisable() {
		getLogger().info("========================");
		getLogger().info("                        ");
		getLogger().info("[CaseOpener] DISABLED   ");
		getLogger().info("                        ");
		getLogger().info("========================");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("casereload")) {
			reloadConfig();
			cg = YamlConfiguration.loadConfiguration(file);
			sender.sendMessage("reloaded succesfully");
		}
		return true;
	}
	
}
	
