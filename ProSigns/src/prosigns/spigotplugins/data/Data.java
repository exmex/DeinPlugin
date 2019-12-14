package prosigns.spigotplugins.data;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	public static File file = new File("plugins//ProSigns//signs.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static HashMap<String, String> Transferdata = new HashMap<>();
	public static HashMap<String, String> Useless = new HashMap<>();

	
	public static int currentsigns;
	public static HashMap<String, Location> Signs = new HashMap<>();
	public static HashMap<Integer, Location> NumberSigns = new HashMap<>();
	public static HashMap<Location, String> BungeeName = new HashMap<>();

	public static HashMap<String, String> Adress = new HashMap<>();

	public static String Prefix = "§8[§eSigns§8] ";
	public static HashMap<String, Boolean> createsign = new HashMap<>();
	
}
