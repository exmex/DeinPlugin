package de.leitung.classes;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TickerCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player)sender;
		
		
		if(cmd.getName().equalsIgnoreCase("getticker")){
			if(p.hasPermission("claymc.admin")){
				if(args.length == 2){
					String target = args[0];
					String gruppe = args[1];
					String group = PermissionsEx.getUser(p).getGroups()[0].getName();
					File file = new File("plugins//LobbyTicker//ticker.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					if(cfg.get(gruppe + ".") == null){
						p.sendMessage("§cDer Angegebene Gruppen-Name ist nicht in der Config bekannt! §3" + gruppe);
						return true;
					}
					if(cfg.get(gruppe + "." + target) == null){
						p.sendMessage("§cDer Angegebene Spieler ist nicht in der Config bekannt! §3" + target);
						return true;
					}
					int i = cfg.getInt(gruppe + "." + target);
					p.sendMessage("§3Der Ticker sagt folgendes: §6" + i); 
				}else{
					p.sendMessage("§c/Getticker [Spieler] [Gruppe]");
				}
	}
		}else{
			p.sendMessage("§cNenene, Kollege. So nicht...");
		}
		return false;
	}
	
	

}
