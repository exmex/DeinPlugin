package de.codeexception.oneversusone;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.codeexception.commands.Build;
import de.codeexception.commands.Stats;
import de.codeexception.commands.Top;
import de.codeexception.events.Chat;
import de.codeexception.events.PlayerEvents;
import de.codeexception.events.Spawn;
import de.codeexception.utils.GameState;
import de.codeexception.utils.Map;
import de.codeexception.utils.MySQL;
import de.codeexception.utils.SQLStats;

public class Main extends JavaPlugin {

	public static final String px = "§e1vs1 §8» §7";
	public static ArrayList<String> topplayers = new ArrayList<>();
	public static Main instance;
	public static GameState state;
	public static Map lobby;
	public static Map spawn1;
	public static Map spawn2;

	public void onEnable() {
	
		
		
	
		state = GameState.Lobby;
		MySQL.connect();
		SQLStats.setup();
		registerCommands();
		registerEvents();
		instance = this;
		loadMaps();
		for(Entity ent : Bukkit.getWorld(Bukkit.getWorld("world").getName()).getEntities()) {
			ent.remove();
	}
	}
	public void onDisable() {
		MySQL.close();
	}
	public void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
		Bukkit.getPluginManager().registerEvents(new Build(), this);
		Bukkit.getPluginManager().registerEvents(new Spawn(), this);
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
	}
	public void registerCommands() {
		getCommand("top").setExecutor(new Top());
		getCommand("stats").setExecutor(new Stats());
		getCommand("build").setExecutor(new Build());
	}
	public static Plugin getInstance() {
		return instance;
	}
	public void loadtopPlayers() {
		topplayers = SQLStats.getTopPlayers();
	}
	public void loadMaps() {
		
		
		
	}
	
}
