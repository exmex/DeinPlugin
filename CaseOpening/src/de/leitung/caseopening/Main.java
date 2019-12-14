package de.leitung.caseopening;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static String Prefix = "§8[§3CaseOpening§8] ";
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Interact(this), this);
	}
}
