package bedwars.utils;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	public static String Prefix = "§8[§cBedWars§8] ";
	
	public static File file = new File("plugins//BedWars//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
}
