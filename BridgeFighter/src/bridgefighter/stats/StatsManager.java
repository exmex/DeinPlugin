package bridgefighter.stats;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class StatsManager {

	public static HashMap<String, Integer> kills = new HashMap<>();
	public static HashMap<String, Integer> deaths = new HashMap<>();
	public static HashMap<String, Integer> wins = new HashMap<>();
	public static File file = new File("plugins//BridgeFighter//stats.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static void loadStatsFromPlayerIntoHashMap(Player p) throws IOException {
		if (cfg.get(p.getUniqueId() + ".Kills") == null) {
			cfg.set(p.getUniqueId() + ".Kills", 0);
			cfg.set(p.getUniqueId() + ".Deaths", 0);
			cfg.set(p.getUniqueId() + ".Wins", 0);
			kills.put(p.getName(), 0);
			deaths.put(p.getName(), 0);
			wins.put(p.getName(), 0);
			cfg.save(file);
			return;
		}
		kills.put(p.getName(), cfg.getInt(p.getUniqueId() + ".Kills"));
		deaths.put(p.getName(), cfg.getInt(p.getUniqueId() + ".Deaths"));
		wins.put(p.getName(), cfg.getInt(p.getUniqueId() + ".Wins"));
		return;
	}

	public static void loadStatsFromPlayerIntoConfig(Player p) throws IOException {
		cfg.set(p.getUniqueId() + ".Kills", kills.get(p.getName()));
		cfg.set(p.getUniqueId() + ".Deaths", deaths.get(p.getName()));
		cfg.set(p.getUniqueId() + ".Wins", wins.get(p.getName()));
		cfg.save(file);
		return;
	}
}
