package spigotplugins.skywars.storage;

import java.util.HashMap;

import org.bukkit.Location;

public class Data {

	public static String Prefix = "§8[§6SkyWars§8] ";
	public static GameState gs;
	public static boolean runlobbycountdown = false;
	public static boolean runmovecountdown;

	public static HashMap<String, Location> Locs = new HashMap<>();
	public static HashMap<Integer, Location> MapLocs = new HashMap<>();
	public static String MapName;
}
