package de.golgolex.freebuild.methods;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Data {
	
	public static String pr = "§8┃ §2Freebuild §8» ";
	public static String noperm = "§8┃ §2Freebuild §8» §7Du hast keine Rechte diesen Command auszuführen";
	
	public static ArrayList<Player> teleport = new ArrayList<>();	
	public static HashMap<Player, Player> deathcount = new HashMap<>();
	public static HashMap<String, Location> Home = new HashMap<>();
	public static HashMap<String, Location> Spawn = new HashMap<>();
	
}
