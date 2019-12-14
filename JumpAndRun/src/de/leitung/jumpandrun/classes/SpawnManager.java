package de.leitung.jumpandrun.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

public class SpawnManager {
	
	public static File file = new File("plugins//JumpAndRun//spawn.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	

	public static void createConfig(Location loc , String path , File file , YamlConfiguration cfg ) {
		cfg.set(path + ".World", loc.getWorld().getName());
		cfg.set(path + ".X", loc.getX());
		cfg.set(path + ".Y", loc.getY());
		cfg.set(path + ".Z", loc.getZ());
		cfg.set(path + ".Yaw", loc.getYaw());
		cfg.set(path + ".Pitch", loc.getPitch());
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Location getConfigLoc(String path , YamlConfiguration cfg) {
		World w = Bukkit.getWorld(cfg.getString(path + ".World"));
		double x = cfg.getDouble(path + ".X");
		double y = cfg.getDouble(path + ".Y");
		double z = cfg.getDouble(path + ".Z");
		float yaw = (float)cfg.getDouble(path + ".Yaw");
		float pitch = (float)cfg.getDouble(path + ".Pitch");
		return new Location(w, x , y , z , yaw , pitch);
	}

}
