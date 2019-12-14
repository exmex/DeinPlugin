package de.leitung.cmdblock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new CMDBLOCK(), this);
	}

}
