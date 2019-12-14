package de.community.utils;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	public static String Prefix = "§8| §a§lC§b§lL§c§lA§5§lY§3§lUnity§8 » ";
	public static File file = new File("plugins//Community//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
}
