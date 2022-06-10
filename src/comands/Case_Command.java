package comands;

import CaseOpener.Main;
import classes.CaseAPI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Case_Command implements CommandExecutor {
    Main pl;
    public Case_Command(Main main) {
        pl = main;
    }
    @Override
    public boolean onCommand(CommandSender wysylajacy, Command komenda, String arg2, String[] args) {
        if(wysylajacy instanceof Player) {
            Player p = (Player) wysylajacy;
            if(args.length == 3) {
                if(args[0].equalsIgnoreCase("case")) {
                    if(p.hasPermission(pl.getConfig().getString("PERMISSION_ADMIN_CASE"))) {
                        if(Integer.parseInt(args[1]) <= 5) {
                            p.getInventory().addItem(CaseAPI.newItem(Material.CHEST, Integer.parseInt(args[2]), pl.getConfig().getString("Names.Tier " + args[1] + " Case.Name").replace("&", "§")));
                        }
                    }
                }
                if(args[0].equalsIgnoreCase("key")) {
                    if(p.hasPermission(pl.getConfig().getString("PERMISSION_ADMIN_KEY"))) {
                        if(Integer.parseInt(args[1]) <= 5) {
                            p.getInventory().addItem(CaseAPI.newItem(Material.TRIPWIRE_HOOK, Integer.parseInt(args[2]), pl.getConfig().getString("Names.Tier " + args[1] + " key.Name").replace("&", "§")));
                        }
                    }

                }
                if(args[0].equalsIgnoreCase("all")) {
                    if(p.hasPermission(pl.getConfig().getString("PERMISSION_ADMIN_CASE")) && p.hasPermission(pl.getConfig().getString("PERMISSION_ADMIN_KEY"))) {
                        if(Integer.parseInt(args[1]) <= 5) {
                            p.getInventory().addItem(CaseAPI.newItem(Material.CHEST, Integer.parseInt(args[2]), pl.getConfig().getString("Names.Tier " + args[1] + " Case.Name").replace("&", "§")));
                            p.getInventory().addItem(CaseAPI.newItem(Material.TRIPWIRE_HOOK, Integer.parseInt(args[2]), pl.getConfig().getString("Names.Tier " + args[1] + " key.Name").replace("&", "§")));
                        }

                    }
                }
            }
        }

        return false;
    }

}
