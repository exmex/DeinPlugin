package de.ttt.stats;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class StatsManager {

	public static HashMap<String, Integer> detectivepaesse = new HashMap<>();
	public static HashMap<String, Integer> traitorpaesse = new HashMap<>(); 

	
	public static void loadStatsFormPlayer(Player p){
		detectivepaesse.put(p.getName(), 0);
		traitorpaesse.put(p.getName(), 0);
	}
}
