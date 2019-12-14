package de.leitung.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.leitung.data.Data;

public class SetSpawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		
		Player p = (Player)s;
		if(p.hasPermission("claymc.admin")){
			
			if(args.length == 0){
			p.sendMessage(Data.Prefix + "§cSetze den Spawn mit: §3/SetSpawn [Zahl]");
			return true;
			}
			if(args.length == 1){
				int i = Integer.parseInt(args[0]);
				File file = new File("plugins//Event//spawn.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				
				cfg.set("Spawn.X." + i , p.getLocation().getX());
                cfg.set("Spawn.Y." + i, p.getLocation().getY());
                cfg.set("Spawn.Z." + i, p.getLocation().getZ());
                cfg.set("Spawn.Yaw." + i, Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn.Pitch." + i, Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn.WeltName." + i, p.getLocation().getWorld().getName());
                try {
					cfg.save(file);
				} catch (IOException e) {
					p.sendMessage(Data.Prefix + "§cEs ist ein Fehler aufgetreten §8» §9" + i); 
				}
                p.sendMessage(Data.Prefix + "§eDu hast den Spawn §6gesetzt §8» §9" + i);
                
                
                
			}
			
		}else{
			p.sendMessage(Data.NoPerm);
		}
		
		return false;
	}
	
	
	

}
