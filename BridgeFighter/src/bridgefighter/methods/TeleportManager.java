package bridgefighter.methods;

import java.awt.List;
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import bridgefighter.data.Data;

public class TeleportManager {
	public static File file = new File("plugins//BridgeFighter//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static Location loadSpawn(String Name) {
		if (cfg.get(Name + ".X") == null) {

			System.out.println("Returned Null");
			return null;
		}
		double x = cfg.getDouble(Name + ".X");
		double y = cfg.getDouble(Name + ".Y");
		double z = cfg.getDouble(Name + ".Z");
		float yaw = (float) cfg.getDouble(Name + ".Yaw");
		float pitch = (float) cfg.getDouble(Name + ".Pitch");
		String wn = cfg.getString(Name + ".WeltName");
		Location loc = new Location(Bukkit.getWorld(wn), x, y, z);
		loc.setYaw(yaw);
		loc.setPitch(pitch);
		return loc;
	}

	public static void setSpawn(String Name, Location loc) {
		cfg.set(Name + ".X", loc.getX());
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
		if (cfg.getStringList("Maps") == null) {
			return;
		} else {
			Data.Maps = cfg.getStringList("Maps");
			if (Data.Maps.contains(Name)) {
				return;
			}
			for (int i = 0; i < Data.Maps.size(); i++) {
				Data.MapLocations.put(Data.Maps.get(i), loadSpawn(Data.Maps.get(i)));
			}
		}

	}
}
