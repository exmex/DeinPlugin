package de.ttt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ttt.utils.Data;

public class SpawnManager implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(args.length != 1){
				if(s instanceof Player){
					String warp = args[0];
					
				}else{
					s.sendMessage(Data.prefix + "§cDu musst dafür auf dem Server sein!");
				}
			}else{
				s.sendMessage(Data.prefix + "§cBitte gebe ein: §e/SetSpawn [Warp]");
			}
		}
		return false;
	}
	
	

}
