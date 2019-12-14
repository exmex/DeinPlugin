package de.Niclas.EarlyHG;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	
	public static int time = 2;
	public static String prefix = "§8[§aSpeedFFA§8] ";
	
	public static File file = new File("plugins/EarlyHG", "loc.yml");
	public static FileConfiguration cfg = YamlConfiguration
			.loadConfiguration(file);
	
	public static void setLocation(String path, Location loc) {
		cfg.set(path + ".x", loc.getX());
		cfg.set(path + ".y", loc.getY());
		cfg.set(path + ".z", loc.getZ());
		cfg.set(path + ".yaw", loc.getYaw());
		cfg.set(path + ".world", loc.getWorld().getName());
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int s1 = 0;
	public static int s2 = 0;
	public static int s3 = 0;
	public static int s4 = 0;
	public static int s5 = 0;
	public static int s6 = 0;

	public static Location getLocation(String path) {
		Location loc = new Location(Bukkit.getWorld(cfg.getString(path
				+ ".world")), cfg.getDouble(path + ".x"), cfg.getDouble(path
				+ ".y"), cfg.getDouble(path + ".z"));
		loc.setYaw((float) cfg.getDouble(path + ".yaw"));
		return loc;
	}


}
