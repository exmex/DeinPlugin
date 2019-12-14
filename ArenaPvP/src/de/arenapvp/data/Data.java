package de.arenapvp.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	public static File instancesfile = new File("plugins//ArenaPvP//instances.yml");
	public static YamlConfiguration instancescfg = YamlConfiguration.loadConfiguration(instancesfile);
	
	
	public static String Prefix = "§8[§eArenaPvP§8] ";
	public static String NoPerm = Prefix + "§cDu hast keine Rechte um dies zu tun!";
	public static List<String> instancelist;
	public static List<String> arenalist;
	
	public static void loadInstancList(){
		instancelist = instancescfg.getStringList("Instances");
	}
	public static void saveInstanceList(){
		instancescfg.set("Instances", instancelist);
		try {
			instancescfg.save(instancesfile);
		} catch (IOException e) {
		}
	}
	
}
