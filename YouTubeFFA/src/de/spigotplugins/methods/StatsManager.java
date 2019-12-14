package de.spigotplugins.methods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.spigotplugins.ffa.data.Data;

public class StatsManager {
	
	public static HashMap<UUID, Integer> kills = new HashMap<>();
	public static HashMap<UUID, Integer> deaths = new HashMap<>();
	public static File file = new File("plugins//FFA//stats.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void loadStatsFromConfigIntoHashMap(Player p){
		kills.put(p.getUniqueId(), cfg.getInt(p.getUniqueId() + ".Kills"));
		deaths.put(p.getUniqueId(), cfg.getInt(p.getUniqueId() + ".Deaths"));
	}
	public static void loadStatsFromHashMapIntoConfig(Player p){
		cfg.set(p.getUniqueId() + ".Kills", kills.get(p.getUniqueId()));
		cfg.set(p.getUniqueId() + ".Deaths", deaths.get(p.getUniqueId()));
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void checkIfStatsDataExists(){
	if(file.exists()){
		return;
	}else{
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bukkit.broadcastMessage(Data.Prefix + "§aDie §eStatsDatei §awurde erfolgreich erstellt!");
	}
	}
}
