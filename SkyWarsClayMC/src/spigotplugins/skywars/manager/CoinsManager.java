package spigotplugins.skywars.manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.main.Boards;
import spigotplugins.skywars.main.StatsManager;
import spigotplugins.skywars.storage.Data;

public class CoinsManager implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("addcoins")){
			if(s.hasPermission("claymc.admin")){
				if(args.length == 2){
					Player p = (Player)s;
					new Manager().addInt(p.getUniqueId(), p.getName(), "SKYWARS", "COINS", Integer.parseInt(args[1]));
					p.sendMessage(Data.Prefix + "§aCoins gegeben!");
					StatsManager.Coins.put(p.getName(), Integer.parseInt(args[1]) + StatsManager.Coins.get(p.getName()));
					Boards.setBoard(p);
				}else{
					s.sendMessage(Data.Prefix + "§c/Addcoins NAME ANZAHL");
				}
			}
		}
		return false;
	}
	

}
