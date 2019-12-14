package de.golgolex.freebuild.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.golgolex.freebuild.methods.FreebuildAPI;

public class CMD_setspawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("claymc.admin")){
				if(args.length == 0){
					FreebuildAPI.setHub(p);
				}
			}
		}
		
		return false;
	}

}
