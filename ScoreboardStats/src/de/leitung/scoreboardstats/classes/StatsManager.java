package de.leitung.scoreboardstats.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class StatsManager {


	
	public static void addKill(Player p){
		File file = new File("plugins//Scorebord//stats.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int i = 0;
		if(cfg.get(p.getUniqueId() + ".Kills") == null){
			cfg.set(p.getUniqueId() + ".Kills", 0);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
			
		}else{
			int ia = cfg.getInt(p.getUniqueId() + ".Kills");
			cfg.set(p.getUniqueId() + ".Kills", ia + 1);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		}
	}
	public static int getKills(Player p){
		File file = new File("plugins//Scorebord//stats.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int ia = 0;
		if(cfg.get(p.getUniqueId() + ".Kills") == null){
			cfg.set(p.getUniqueId() + ".Kills", 0);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		}else{
			ia = cfg.getInt(p.getUniqueId() + ".Kills");
		}
		return ia;
	}
	
	
	public static void addDeath(Player p){
		File file = new File("plugins//Scorebord//stats.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int i = 0;
		if(cfg.get(p.getUniqueId() + ".Deaths") == null){
			cfg.set(p.getUniqueId() + ".Deaths", 0);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
			
		}else{
			int ia = cfg.getInt(p.getUniqueId() + ".Deaths");
			cfg.set(p.getUniqueId() + ".Deaths", ia + 1);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		}
	}
	public static int getDeaths(Player p){
		File file = new File("plugins//Scorebord//stats.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int ia = 0;
		if(cfg.get(p.getUniqueId() + ".Deaths") == null){
			cfg.set(p.getUniqueId() + ".Deaths", 0);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		}else{
			ia = cfg.getInt(p.getUniqueId() + ".Deaths");
		}
		return ia;
	}
}
