package clayhandler;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	public static int ServerClays;
	public static int CurrentClays;
	public static String Prefix = "§8[§eClays§8] ";
	public static File file = new File("plugins//ClayHandler//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
}
