package de.ttt.utils;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	public static String prefix = "§8[§3TTT§8] ";
	public static String noPerms = prefix + "§cDu hast nicht genügend Rechte um dies zu tun!";
	public static File file = new File("plugins//TTT//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
}
