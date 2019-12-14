package de.spigotplugins.lobby.configmanager;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	public static File spawns = new File("plugins//LobbySystem//Spawns.yml");
	public static YamlConfiguration spawncfg = YamlConfiguration.loadConfiguration(spawns);
	
	public static File config = new File("plugins//LobbySystem//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(config);
	
}
