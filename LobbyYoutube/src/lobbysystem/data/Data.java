package lobbysystem.data;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	public static String Prefix = "§8[§cLobby§8] ";
	public static String NoPerm = Prefix + "§cDu hast keine Rechte um dies zu tun!";
	public static File file = new File("plugins//LobbySystem//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static Location spawn;
	public static Location spawn1;
	public static Location spawn2;
	public static Location spawn3;
	public static Location spawn4;
	public static Location spawn5;
	public static Location spawn6;

}
