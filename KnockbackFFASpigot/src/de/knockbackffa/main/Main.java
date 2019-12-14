package de.knockbackffa.main;

import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import de.knockbackffa.commands.Setspawn;
import de.knockbackffa.listener.Damage;

public class Main extends JavaPlugin{
	
	public static Location MainSpawn;
	public static Location ArenaSpawn;
	public static String Prefix;
	public static boolean BungeeMode;
	public static boolean GetHitDamage;
	public static String JoinMessage;
	public static String QuitMessage;
	public static String NoPermissions;
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("§7§m----------------------------------");
		Bukkit.getConsoleSender().sendMessage("§3Loading Config...");
		try{
		loadConfig();
		processConfig();
		registerListener();
		setMainSpawn();
		setArenaSpawn();
		}catch(Exception e1){
			Bukkit.getConsoleSender().sendMessage("§4Failure to load config");
			Bukkit.getConsoleSender().sendMessage("§4Please try to delete the configuration");
			Bukkit.getConsoleSender().sendMessage("§7§m----------------------------------");
			return;
		}
		Bukkit.getConsoleSender().sendMessage("§2Successfully loaded the config");
		Bukkit.getConsoleSender().sendMessage("§7§m----------------------------------");
		Bukkit.getConsoleSender().sendMessage("§5Have fun with KnockIT by Regnatrix and Anweisung!");

	}
	public void loadConfig(){
		this.reloadConfig();
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().header("### File Configuration for KnockIT (Note: Your entrys may be differently if you use BungeeMode = true ; false!) ###");
		this.getConfig().addDefault("Prefix", "&8[&3KnockIT&8]");
		this.getConfig().addDefault("NoPermissions", "%Prefix% &cYou don't have the required permissions to do this!");
		this.getConfig().addDefault("BungeeMode", false);
		this.getConfig().addDefault("GetHitDamage", false);
		this.getConfig().addDefault("BungeeModeJoinMessage", "%Prefix% &6%Player% &3had joined this game!");
		this.getConfig().addDefault("BungeeModeQuitMessage", "%Prefix% &6%Player% &3had &cleft &3this game!");


		this.saveConfig();
	}
	public void processConfig(){
		Prefix = this.getConfig().getString("Prefix").replace("&", "§");
		BungeeMode = this.getConfig().getBoolean("BungeeMode");
		JoinMessage = this.getConfig().getString("BungeModeJoinMessage").replace("%Prefix%", Prefix).replace("&", "§");
		QuitMessage = this.getConfig().getString("BungeModeQuitMessage").replace("%Prefix%", Prefix).replace("&", "§");
		NoPermissions = this.getConfig().getString("NoPermissions").replace("%Prefix%", Prefix).replace("&", "§");
		GetHitDamage = this.getConfig().getBoolean("GetHitDamage");
	}
	
	public void registerListener() {
		getServer().getPluginManager().registerEvents(new Damage(), this);
				
	}
	public void setMainSpawn(){
		if(BungeeMode = true){
		try{
			Location loc = MainSpawn;
			Setspawn.setMainSpawnLocation(loc);
		}catch(Exception e1){
			Bukkit.getConsoleSender().sendMessage("§4You havn't set the main spawn yet! [/SetSpawn Spawn]");
			return;
		}
		}else{
			return;
		}
	}
	public void setArenaSpawn(){
		try{
		Location loc = ArenaSpawn;
		Setspawn.setArenaSpawnLocation(loc);
	}catch(Exception e1){
		Bukkit.getConsoleSender().sendMessage("§4You havn't set the arena spawn yet! [/SetSpawn Arena]");
		return;
	}
	}
}
