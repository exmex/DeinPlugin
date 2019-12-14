package de.knockbackffa.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.knockbackffa.main.Main;

public class Setspawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("knockit.setspawn")){
				if(args[0].equalsIgnoreCase("spawn")){
					setMainSpawn(p);
				}else if(args[0].equalsIgnoreCase("arena")){
					setArenaSpawn(p);
				}
			}else{
				p.sendMessage(Main.NoPermissions);
			}
		}
		return false;
	}
	public void setMainSpawn(Player p){
		
	}
	public void setArenaSpawn(Player p){
		
	}
	public static void setMainSpawnLocation(Location loc){
		
	}
	public static void setArenaSpawnLocation(Location loc){
		
	}
}
