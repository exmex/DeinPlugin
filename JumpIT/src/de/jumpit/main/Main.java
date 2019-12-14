package de.jumpit.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.jumpit.commands.SetSpawn;
import de.jumpit.itemfunctions.CompassClickEvent;
import de.jumpit.itemfunctions.CompassListener;
import de.jumpit.itemfunctions.SaveInventoryContents;
import de.jumpit.itemfunctions.SaveInventoryListener;
import de.jumpit.listener.Join;
import de.jumpit.utils.Data;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§aDas Plugin startet...");
		Bukkit.getPluginManager().registerEvents(new CompassClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new CompassListener(), this);
		Bukkit.getPluginManager().registerEvents(new Join(), this);

		getCommand("setspawn").setExecutor(new SetSpawn());
	}
	
}
