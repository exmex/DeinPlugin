package de.golgolex.freebuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.golgolex.freebuild.main.Main;
import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.FreebuildAPI;

public class CMD_spawn implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("spawn")){
			if(p.hasPermission("claymc.spawn")){
				if(args.length == 0){
					
					if(Data.Spawn == null){
						
						p.sendMessage(Data.pr + "§7Du wirst in §a5 §7Sekunden zum Spawn teleportiert. Bitte bewege dich nicht");
						
						Data.teleport.add(p);
						
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.main, new Runnable(){

							@Override
							public void run() {
								if(Data.teleport.contains(p)){
									Data.teleport.remove(p);
									p.teleport(FreebuildAPI.getHub(p));
									p.sendMessage(Data.pr + "§7Du wurdest efolgreich zum Spawn teleportiert");
								}
							}
							
						}, 100);
					}else{
						
						p.sendMessage(Data.pr + "§7Du wirst in §a5 §7Sekunden zum Spawn teleportiert. Bitte bewege dich nicht");
						
						Data.teleport.add(p);
						
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.main, new Runnable(){

							@Override
							public void run() {
								if(Data.teleport.contains(p)){
									Data.teleport.remove(p);
									p.teleport(FreebuildAPI.getHub(p));
									p.sendMessage(Data.pr + "§7Du wurdest efolgreich zum Spawn teleportiert");
								}
							}
							
						}, 100);
						
					}
				}
			}
		}
		
		return false;
	}

}
