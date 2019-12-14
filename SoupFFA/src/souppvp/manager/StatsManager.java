package souppvp.manager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import souppvp.methods.Scoreboard;

public class StatsManager {
	public static HashMap<String, Integer> kills = new HashMap<>();
	public static HashMap<String, Integer> deaths = new HashMap<>();
	public static HashMap<String, Integer> coins = new HashMap<>();
	
	
	public static File file = new File("plugins//SoupPvP//stats.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static void loadStatsFormConfigIntoHashMap(Player p){
		if(cfg.get(p.getUniqueId() + ".Kills") == null){
			cfg.set(p.getUniqueId() + ".Kills", 0);
			cfg.set(p.getUniqueId() + ".Deaths", 0);
			cfg.set(p.getUniqueId() + ".Coins", 500);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			kills.put(p.getUniqueId().toString(), 0);
			deaths.put(p.getUniqueId().toString(), 0);
			coins.put(p.getUniqueId().toString(), 500);
			Scoreboard.setScoreboard(p);
		}else{
			kills.put(p.getUniqueId().toString(), cfg.getInt(p.getUniqueId() + ".Kills"));
			deaths.put(p.getUniqueId().toString(), cfg.getInt(p.getUniqueId() + ".Deaths"));
			coins.put(p.getUniqueId().toString(), cfg.getInt(p.getUniqueId() + ".Coins"));
		}
	}
	public static void loadStatsFromHashMapIntoConfig(Player p){
		cfg.set(p.getUniqueId().toString() + ".Kills", kills.get(p.getUniqueId().toString()));
		cfg.set(p.getUniqueId().toString() + ".Deaths", deaths.get(p.getUniqueId().toString()));
		cfg.set(p.getUniqueId().toString() + ".Coins", coins.get(p.getUniqueId().toString()));
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addKill(Player p){
		kills.put(p.getUniqueId().toString(), kills.get(p.getUniqueId().toString()) +1);
	}
	public static void addDeath(Player p){
		deaths.put(p.getUniqueId().toString(), deaths.get(p.getUniqueId().toString()) +1);
	}
	public static void removeCoins(Player p, int Anzahl){
		int i = coins.get(p.getUniqueId().toString()) - Anzahl;
		coins.put(p.getUniqueId().toString(), i);
	}
}
