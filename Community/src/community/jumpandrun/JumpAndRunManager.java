package community.jumpandrun;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class JumpAndRunManager {

	static File file = new File("plugins//Community//jnr.yml");
	static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void setSpawn(Location loc, String Name){
	cfg.set(Name + ".X" , loc.getX());
	cfg.set(Name + ".Y", loc.getY());
	cfg.set(Name + ".Z", loc.getZ());
	cfg.set(Name + ".Yaw", loc.getYaw());
	cfg.set(Name + ".Pitch", loc.getPitch());
	cfg.set(Name + ".WeltName", loc.getWorld().getName());
	try {
		cfg.save(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void removeSpawn(String Name, Player p){
		cfg.set(Name + ".X" , null);
		cfg.set(Name + ".Y", null);
		cfg.set(Name + ".Z", null);
		cfg.set(Name + ".Yaw", null);
		cfg.set(Name + ".Pitch", null);
		cfg.set(Name + ".WeltName", null);
		cfg.set(Name, null);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void teleportToSpawn(Player p, String Name){
		double x = cfg.getDouble(Name + ".X");
		double y = cfg.getDouble(Name + ".Y");
		double z = cfg.getDouble(Name + ".Z");
		double yaw = cfg.getDouble(Name + ".Yaw");
		double pitch = cfg.getDouble(Name + ".Pitch");
		String weltname = cfg.getString(Name + ".WeltName");

		Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		p.teleport(loc);
	}
}
