package de.jumpit.methods;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class TeleportMethod {
	public static void teleportToSpawn(Player p){
		File file = new File("plugins//JumpIT//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("spawn.world");
        double x = cfg.getDouble("spawn.x");
        double y = cfg.getDouble("spawn.y");
        double z = cfg.getDouble("spawn.z");
        double yaw = cfg.getDouble("spawn.yaw");
        double pitch = cfg.getDouble("spawn.pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        p.teleport(loc);
	}
}
