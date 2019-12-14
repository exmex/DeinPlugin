package servercore.data;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Data {

	public static String Prefix = "§8[§cCore§8] ";
	public static File file = new File("plugins//ServerCore//core.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static ArrayList<Player> playerinvanish = new ArrayList<>();
}
