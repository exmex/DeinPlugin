package de.leitung.jumpandrun.classes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class setSpawn implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		
		
		
		Player p = (Player)sender;
		
		
		
		if(p.hasPermission("claymc.setspawm")) {
			
			
			if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("lobby")) {
					SpawnManager.createConfig(p.getLocation(), "Lobby", SpawnManager.file, SpawnManager.cfg);
					p.sendMessage(Main.Prefix + " §7Lobby-Spawnpunkt gesetzt");
				}else if(args[0].equalsIgnoreCase("JumpenRun")) {
					p.sendMessage(Main.Prefix + " §7Gebe nur /setspawn <JumpenRun/Spawnplatz>  ein!");
				}else if (args[0].equalsIgnoreCase("FFA")){
					SpawnManager.createConfig(p.getLocation(), "FFA", SpawnManager.file, SpawnManager.cfg);
					p.sendMessage(Main.Prefix + " §7Spawnpunkt für FFA gesetzt");
				}else {
					p.sendMessage(Main.Prefix + " §7Gebe nur /setspawn <Lobby/JumpenRun> ein!");
				}
				
				
				
				
				
				
			}else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("JumpenRun")) {
					
					
					int jumpenrund = Integer.parseInt(args[1]);
					
					if(jumpenrund > 0 && jumpenrund <= Main.spawns) {
						SpawnManager.createConfig(p.getLocation(), "JumpenRun" + jumpenrund, SpawnManager.file, SpawnManager.cfg);
						p.sendMessage(Main.Prefix + " §7Du hast den Spawnpunkt für JumpenRun §8» §7 " + jumpenrund +  " §7gesetzt!");
					}else {
						p.sendMessage(Main.Prefix + " §7Warum mehr Spawns setzten als möglich?");
					}
					
					
					try {
						
					}catch (NumberFormatException eb) {
						p.sendMessage(Main.Prefix + " §7Gebe eine gültige Zahl an!");
					}
					
					
					
				}
			}else {
				p.sendMessage(Main.Prefix + " §7Gebe nur /setspawn <Lobby/JumpenRun> ein!");
			}
			
			
			
		}else {
			p.sendMessage(Main.Prefix + " §7Du hast kein §cRecht §7dazu!");
		}
		

		
		
		
		
		return false;
	}

}
