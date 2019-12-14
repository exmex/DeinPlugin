package knockpvp.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	public static String Prefix = "§8| §3KnockPvP§8 » ";
	public static File file = new File("plugins//KnockPvP//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	public static HashMap<String, Integer> roundkills = new HashMap<>();
	
}
