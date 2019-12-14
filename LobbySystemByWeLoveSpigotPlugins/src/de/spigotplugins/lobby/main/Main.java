package de.spigotplugins.lobby.main;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.async.AsyncLogger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.spigotplugins.lobby.configmanager.ConfigMethods;
import de.spigotplugins.lobby.configmanager.Strings;
import de.spigotplugins.lobby.data.Data;
import de.spigotplugins.lobby.listener.JoinListener;
import de.spigotplugins.lobby.listener.WorldProtection;
import de.spigotplugins.logmanager.AsyncLogging;
import de.spigotplugins.logmanager.LogData;
import de.spigotplugins.logmanager.LogMethods;

public class Main extends JavaPlugin{
	public static int logging;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		logging = 5;
		Bukkit.getConsoleSender().sendMessage(LogData.getTime() + "§aDas LobbySystem von §6WeLoveSpigotPlugins §awird aktiviert!");
		Bukkit.getConsoleSender().sendMessage(" ");
		this.getConfig().options().copyDefaults(true);
		this.saveDefaultConfig();
		ConfigMethods.checkIfConfigFilesExists();
		ConfigMethods.loadStrings();
		LogData.checkIfLogFileExists();
		loadEvents();
		Bukkit.getConsoleSender().sendMessage("               " + Strings.Prefix);
		if(Data.Logging == true){
			LogMethods.log("Das LobbySystem wurde gestartet.");
		}
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				logging--;
				if(Data.Logging = true){
				if(logging == 0){
				   AsyncLogging.saveAsyncLogs();
				   logging = 5;
				}
				}
			}
		}, 20, 20);
	}
	public void loadEvents(){
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new WorldProtection(), this);

	}
}
