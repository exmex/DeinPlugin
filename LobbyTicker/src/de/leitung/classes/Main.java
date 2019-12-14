package de.leitung.classes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Ticker(), this);
		getCommand("getticker").setExecutor(new TickerCMD());
	}

}
