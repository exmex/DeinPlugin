package de.leitung.lobby.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Locations {
	 public static File file = new File("plugins/Lobby", "locs.yml");
	    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);

	    public static void setLocation(String path, Location loc) {
	        cfg.set(String.valueOf(path) + ".x", (Object)loc.getX());
	        cfg.set(String.valueOf(path) + ".y", (Object)loc.getY());
	        cfg.set(String.valueOf(path) + ".z", (Object)loc.getZ());
	        cfg.set(String.valueOf(path) + ".yaw", (Object)Float.valueOf(loc.getYaw()));
	        cfg.set(String.valueOf(path) + ".world", (Object)loc.getWorld().getName());
	        try {
	            cfg.save(file);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static Location getLocation(String path) {
	        Location loc = new Location(Bukkit.getWorld((String)cfg.getString(String.valueOf(path) + ".world")), cfg.getDouble(String.valueOf(path) + ".x"), cfg.getDouble(String.valueOf(path) + ".y"), cfg.getDouble(String.valueOf(path) + ".z"));
	        loc.setYaw((float)cfg.getDouble(String.valueOf(path) + ".yaw"));
	        return loc;
	    }
}
