package de.jumpit.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.jumpit.utils.Data;

public class SetSpawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setspawn")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//JumpIT//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				Location loc = p.getLocation();
				double x = loc.getX();
				double y = loc.getY();
				double z = loc.getZ();
				float yaw = loc.getYaw();
				float pitch = loc.getPitch();
				String wn = loc.getWorld().getName();
				cfg.set("spawn.x", x);
				cfg.set("spawn.y", y);
				cfg.set("spawn.z", z);
				cfg.set("spawn.yaw", yaw);
				cfg.set("spawn.pitch", pitch);
				cfg.set("spawn.world", wn);
				p.sendMessage(Data.Prefix + "§3Der Spawn wurde gesetzt!");
				try {
					cfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
			}else{
				p.sendMessage(Data.NoPerm);
			}
		}
		return false;
	}
	
	

}
