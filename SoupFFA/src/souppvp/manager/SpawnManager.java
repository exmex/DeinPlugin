package souppvp.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import souppvp.data.Data;


public class SpawnManager {
	static File file = new File("plugins//SoupPvP//spawns.yml");
	static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static void createSpawn(Player p, Location loc, String SpawnName){
		
			double x = loc.getX();
			double z = loc.getZ();
			double y = loc.getY();
			float pitch = loc.getPitch();
			float yaw = loc.getYaw();
			String WeltName = loc.getWorld().getName();
			cfg.set(SpawnName + ".X", x);
			cfg.set(SpawnName + ".Y", y);
			cfg.set(SpawnName + ".Z", z);
			cfg.set(SpawnName + ".Yaw", yaw);
			cfg.set(SpawnName + ".Pitch", pitch);
			cfg.set(SpawnName + ".WeltName", WeltName);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
	public static void teleportToSpawn(Player p, String SpawnName){
		if(cfg.get(SpawnName + ".X") != null){
			double x = cfg.getDouble(SpawnName + ".X");
			double y = cfg.getDouble(SpawnName + ".Y");
			double z = cfg.getDouble(SpawnName + ".Z");
			float yaw = (float) cfg.getDouble(SpawnName + ".Yaw");
			float pitch = (float) cfg.getDouble(SpawnName + ".Pitch");
			String WeltName = cfg.getString(SpawnName + ".WeltName");
			Location loc = new Location(Bukkit.getWorld(WeltName), x, y, z);
			loc.setYaw(yaw);
			loc.setPitch(pitch);
			p.teleport(loc);
			p.setFireTicks(0);
			return;
		}else{
			p.sendMessage(Data.Prefix + "§cDu konntest nicht zu diesem ''Warp'' teleportiert werden, da dieser nicht existiert!");
			return;
		}
	}
	public static Location getLocation(String SpawnName){
		Location mainloc = null;
			double x = cfg.getDouble(SpawnName + ".X");
			double y = cfg.getDouble(SpawnName + ".Y");
			double z = cfg.getDouble(SpawnName + ".Z");
			float yaw = (float) cfg.getDouble(SpawnName + ".Yaw");
			float pitch = (float) cfg.getDouble(SpawnName + ".Pitch");
			String WeltName = cfg.getString(SpawnName + ".WeltName");
			Location loc = new Location(Bukkit.getWorld(WeltName), x, y, z);
			loc.setYaw(yaw);
			loc.setPitch(pitch);
			mainloc = loc;
	
		return mainloc;
	}
}
