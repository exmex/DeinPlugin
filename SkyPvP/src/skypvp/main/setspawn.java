package skypvp.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class setspawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		
		
		
		
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("SkyPvP.SetSpawn")){
			
				File ordner = new File("plugins//SkyPvP");
				File file = new File ("plugins//SkyPvP//spawns.yml");
				
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					p.sendMessage("§aYou've set the Spawnposition!");
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					float yaw = loc.getYaw();
					float pitch = loc.getPitch();
					String wn = loc.getWorld().getName();
					try{
						
					
					cfg.set("spawn.x", x);
					cfg.set("spawn.y", y);
					cfg.set("spawn.z", z);
					cfg.set("spawn.yaw", yaw);
					cfg.set("spawn.pitch", pitch);
					cfg.set("spawn.world", wn);
					cfg.save(file);
					}catch(Exception e){
						Bukkit.broadcastMessage("§4§lFail to set the spawn in spawns.yml §7[§SetArena-Class§7]");

					}
			}
		}
		return false;
}
}
