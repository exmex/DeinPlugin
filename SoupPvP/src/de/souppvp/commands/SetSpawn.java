package de.souppvp.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.souppvp.data.Data;
import de.souppvp.spawnmanager.SpawnManager;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("claymc.admin")){
				if(args.length == 1){
					String Spawn = args[0];
					SpawnManager.createSpawn(p, p.getLocation(), Spawn);
					p.sendMessage(Data.Prefix + "§eDu hast den Spawn §6" + Spawn + " §eerfolgreich erstellt!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				}else{
					p.sendMessage(Data.Prefix + "§cFalsche Benutzung! Nutze: /SetSpawn Name");
					return true;
				}
			}
		}
		return false;
	}
	
	

}
