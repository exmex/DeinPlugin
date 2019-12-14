package de.golgolex.freebuild.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import de.golgolex.freebuild.commands.CMD_addcoins;
import de.golgolex.freebuild.commands.CMD_home;
import de.golgolex.freebuild.commands.CMD_sethome;
import de.golgolex.freebuild.commands.CMD_setspawn;
import de.golgolex.freebuild.commands.CMD_spawn;
import de.golgolex.freebuild.commands.CMD_tpa;
import de.golgolex.freebuild.listener.LISTENER_AsyncPlayerChatEvent;
import de.golgolex.freebuild.listener.LISTENER_BlockBreakEvent;
import de.golgolex.freebuild.listener.LISTENER_BlockBukkitCommands;
import de.golgolex.freebuild.listener.LISTENER_InventoryClickEvent;
import de.golgolex.freebuild.listener.LISTENER_PlayerDeathEvent;
import de.golgolex.freebuild.listener.LISTENER_PlayerInteractEvent;
import de.golgolex.freebuild.listener.LISTENER_PlayerJoinEvent;
import de.golgolex.freebuild.listener.LISTENER_PlayerMoveEvent;
import de.golgolex.freebuild.listener.LISTENER_PlayerQuitEvent;
import de.golgolex.freebuild.listener.LISTENER_SignChangeEvent;

public class Main extends JavaPlugin{
	
	public static Main main;
	
	/*
	 * Noch zu erledigen:
	 * - Clan Prefixe für den Chat machen [Wusste nicht wie das ClanPlugin heißt]
	 * - Scoreboard richtig machen mit Deaths etc.
	 * - Hashmaps mit Coins etc.
	 * Alles andere ist gemacht.
	 */
	
	public void onEnable(){
		
		main = this;
		
		Bukkit.getConsoleSender().sendMessage("§7[§2FREEBUILD§7] §aDas Plugin wurde erfolgreich aktiviert!");
		
		this.getCommand("addcoins").setExecutor(new CMD_addcoins());
		this.getCommand("setspawn").setExecutor(new CMD_setspawn());
		this.getCommand("sethome").setExecutor(new CMD_sethome());
		this.getCommand("home").setExecutor(new CMD_home());
		this.getCommand("spawn").setExecutor(new CMD_spawn());
		this.getCommand("tpa").setExecutor(new CMD_tpa());
//		this.getCommand("kits").setExecutor(new CMD_kits());
		
		Bukkit.getPluginManager().registerEvents(new LISTENER_BlockBukkitCommands(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_PlayerDeathEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_AsyncPlayerChatEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_PlayerJoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_PlayerQuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_PlayerInteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_SignChangeEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_InventoryClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_BlockBreakEvent(), this);
		Bukkit.getPluginManager().registerEvents(new LISTENER_PlayerMoveEvent(), this);
//		Bukkit.getPluginManager().registerEvents(new CMD_kits(), this);
		
		
	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("§7[§2FREEBUILD§7] §cDas Plugin wurde erfolgreich deaktiviert!");
	}

}
