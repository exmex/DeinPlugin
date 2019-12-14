package de.golgolex.freebuild.methods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Stats {
	
	static File file = new File("plugins//FreeBuild//stats.yml");
	static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static HashMap<UUID, Integer> Coins = new HashMap<>();
	public static HashMap<UUID, Integer> Kills = new HashMap<>();
	public static HashMap<UUID, Integer> Deaths = new HashMap<>();
	
	public static void loadStatsFromConfigIntoHashMap(Player p){
		if(cfg.get(p.getUniqueId() + ".reach") == null){
			Kills.put(p.getUniqueId(), 0);
			Deaths.put(p.getUniqueId(), 0);
			Coins.put(p.getUniqueId(), 500);
			cfg.set(p.getUniqueId() + ".reach", 0);
			cfg.set(p.getUniqueId() + ".played", 0);
			cfg.set(p.getUniqueId() + ".coins", 500);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		Kills.put(p.getUniqueId(), cfg.getInt(p.getUniqueId() + ".reach"));
		Deaths.put(p.getUniqueId(), cfg.getInt(p.getUniqueId() + ".played"));
		Coins.put(p.getUniqueId(), cfg.getInt(p.getUniqueId() + ".coins"));
	}
	public static void loadStatsFromHashMapIntoConfig(Player p){
		
	}
	public static void isFileExisting(){
		File file = new File("plugins//FreeBuild//stats.yml");
		if(file.exists()){
			return;
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			
		}
		
	}
}
