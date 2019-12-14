package de.leitung.jumpandrun.classes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	private static Main plugin;
	
	
	public static String Prefix = "§8[§3J&R§8] ";
	public void onEnable(){
		
		
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new StatsAPI(), this);
		loadCMDS();
		loadListener();
		try {
			loadConfig();
		}catch (Exception e) {
			
			System.out.println("Es gab Fehler bei der Config! Lösungsweg » Config löschen und die Config wird neuerstellt!");
			
			
		}
		
		
		
	}
	
	
	public static Main getPlugin() {
		return plugin;
	}
	
	public static int spawns = plugin.getConfig().getInt("JumpenRun Spawnpunkte"); 
	
	
	public void loadListener() {
		
		
		PluginManager pm = getServer().getPluginManager();
		
	}
	
	public void loadCMDS() {
		
		
		getCommand("setspawn").setExecutor(new setSpawn());
	
	}
	
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		getConfig().options().header("##### JUMPENRUN PLUGIN CONFIG #####");
		getConfig().addDefault("JumpenRun Spawnpunkte", 4);
	    saveConfig();
	    reloadConfig();
	    System.out.println("Config sucessfully loaded!");
	}
	
	

}
