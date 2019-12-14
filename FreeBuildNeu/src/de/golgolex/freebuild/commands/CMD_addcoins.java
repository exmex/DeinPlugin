package de.golgolex.freebuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.Stats;

public class CMD_addcoins implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("addcoins")){
			if(p.hasPermission("claymc.admin")){
				if(args.length == 2){
					Player target = Bukkit.getPlayer(args[0]);
					int i = Integer.valueOf(args[1]);
					
					Stats.Coins.put(target.getUniqueId(), Stats.Coins.get(target.getUniqueId()) + i);
					
					//--
					
					p.sendMessage(Data.pr + "§7Du hast dem Spieler §2" + target + " §a" + args[1] + " §7Coins gegeben");
					target.sendMessage(Data.pr + "§7Du hast §a" + args[1] + " §7Coins bekommen");
				
					//--
					
					for(Player all : Bukkit.getOnlinePlayers()){
						
					}
					
					
				}else{
					p.sendMessage(Data.pr + "§7Bitte benutze §2/addcoins [Name] [anzahl]");
				}
			}
		}
		
		return false;
	}

}
