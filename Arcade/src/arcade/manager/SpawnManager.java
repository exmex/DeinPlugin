package arcade.manager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SpawnManager {

	public static File file = new File("plugins//Arcade//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static HashMap<String, Location> mainLocations = new HashMap<>();
	
	
	public static void setSpawn(Player p, String Name, Location loc){
	cfg.set(Name + ".X", p.getLocation().getX());
	cfg.set(Name + ".Y", p.getLocation().getY());
	cfg.set(Name + ".Z", p.getLocation().getZ());
	cfg.set(Name + ".Yaw", p.getLocation().getYaw());
	cfg.set(Name + ".Pitch", p.getLocation().getPitch());
	cfg.set(Name + ".WeltName", p.getLocation().getWorld().getName());
	try {
		cfg.save(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static Location loadLocationFromConfig(String Name){
		
	Location loc = new Location(Bukkit.getWorld(cfg.getString(Name + ".WeltName")), cfg.getDouble(Name + ".X"), cfg.getDouble(Name + ".Y"), cfg.getDouble(Name + ".Z"));
	loc.setYaw((float) cfg.getDouble(Name + ".Yaw"));
	loc.setPitch((float) cfg.getDouble(Name + ".Pitch"));
	
	return loc;
	}
	}
