package de.skywars.utils;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	public static String Prefix = "§8| §3SkyWars§8 » ";
	
	public static List<String> MapNamen;
	public static File file = new File("plugins//SkyWars//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
}
