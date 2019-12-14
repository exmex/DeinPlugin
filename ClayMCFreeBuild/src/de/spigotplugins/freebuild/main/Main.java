package de.spigotplugins.freebuild.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.spigotplugins.freebuild.data.Data;

public class Main extends JavaPlugin{

	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§aLoading...");
		
	}
}
