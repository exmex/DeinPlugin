package servercore.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import servercore.data.Data;

public class Fly implements CommandExecutor{
	ArrayList<Player> list = new ArrayList<>();
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("fly")){
			if(args.length == 0){
				if(p.hasPermission("core.fly")){
					if(list.contains(p)){
						list.remove(p);
						p.setFlying(false);
						p.setAllowFlight(false);
						p.sendMessage(Data.Prefix + "§eDu hast deinen §6Flugmodus §eausgestellt!");
						return true;
					}
					if(!list.contains(p)){
						list.add(p);
						p.setAllowFlight(true);
						p.setFlying(true);
						p.sendMessage(Data.Prefix + "§eDu hast deinen §6Flugmodus §eangestellt!");
					}
				}else{
					p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies durchzuführen!");
				}
				return true;
			}
			if(args.length == 1){
				if(p.hasPermission("core.fly")){
					Player tar = Bukkit.getPlayer(args[0]);
					if(tar != null){
						if(tar != p){
							if(list.contains(tar)){
								list.remove(tar);
								tar.setFlying(false);
								tar.setAllowFlight(false);
								p.sendMessage(Data.Prefix + "§6"+ tar.getName() + "§e kann nun nicht mehr fliegen!");
								tar.sendMessage(Data.Prefix + "§eDu darfst nun nicht mehr fliegen!");
								return true;
							}
							if(!list.contains(tar)){
								list.add(tar);
								tar.setFlying(false);
								tar.setAllowFlight(false);
								p.sendMessage(Data.Prefix + "§6"+ tar.getName() + "§e hat nun den Flugmodus!");
								tar.sendMessage(Data.Prefix + "§eDu darfst nun fliegen!");

								return true;
							}
						}else{
							if(list.contains(p)){
								list.remove(p);
								p.setFlying(false);
								p.setAllowFlight(false);
								p.sendMessage(Data.Prefix + "§eDu hast deinen §6Flugmodus §eausgestellt!");
								return true;
							}
							if(!list.contains(p)){
								list.add(p);
								p.setAllowFlight(true);
								p.setFlying(true);
								p.sendMessage(Data.Prefix + "§eDu hast deinen §6Flugmodus §eangestellt!");
							}
						}
					}else{
						p.sendMessage(Data.Prefix + "§cDieser Spieler ist nicht online!");
					}
				}else{
					p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies durchzuführen!");
				}
			}
			
		}
		return false;
	}
	
	

}
