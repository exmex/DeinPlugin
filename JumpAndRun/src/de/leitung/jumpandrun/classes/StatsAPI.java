package de.leitung.jumpandrun.classes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class StatsAPI implements Listener{
	
	public static HashMap<Player, Integer> kills = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> deaths = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> coins = new HashMap<Player, Integer>();

	File file = new File("plugins//JumpAndRun//stats.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
	if(cfg.get(p.getUniqueId() + ".Kills") == null){
		cfg.set(p.getUniqueId() + ".Kills", 0);
		cfg.set(p.getUniqueId() + ".Deaths", 0);
		cfg.set(p.getUniqueId() + ".Coins", 0);
		kills.put(p, 0);
		deaths.put(p, 0);
		coins.put(p, 0);
		try {
			cfg.save(file);
		} catch (IOException e1) {
			p.kickPlayer("§cEs gab einen Fehler. Bitte versuche es erneut!");
		}
	}
	int killsc = cfg.getInt(p.getUniqueId() + ".Kills");
	int deathsc = cfg.getInt(p.getUniqueId() + ".Deaths");
	int coinsc = cfg.getInt(p.getUniqueId() + ".Coins");
	kills.put(p, killsc);
	deaths.put(p, deathsc);
	coins.put(p, coinsc);
	return;
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		cfg.set(p.getUniqueId() + ".Kills", kills.get(p));
		cfg.set(p.getUniqueId() + ".Deaths", deaths.get(p));
		cfg.set(p.getUniqueId() + ".Coins", coins.get(p));
		try {
			cfg.save(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void addKill(Player p){
		kills.put(p, kills.get(p) +1);
		return;
	}
	public static int getKills(Player p){
		return kills.get(p);
	}
	public static void addDeath(Player p){
		deaths.put(p, deaths.get(p) +1);
		return;
	}
	public static int getDeaths(Player p){
		return deaths.get(p);
	}
	public static void addCoins(Player p, int Anzahl){
		int totalcoins = coins.get(p);
		int finalcoins = totalcoins + Anzahl;
		coins.put(p, finalcoins);
		return;
	}
	public static void removeCoins(Player p, int Anzahl){
		int totalcoins = coins.get(p);
		int finalcoins = totalcoins - Anzahl;
		coins.put(p, finalcoins);
		return;
	}
	public static void setCoins(Player p, int Anzahl){
		coins.put(p, Anzahl);
	}
}
