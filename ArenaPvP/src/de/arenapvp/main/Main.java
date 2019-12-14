package de.arenapvp.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.arenapvp.data.Data;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6Das System wird nun startbereit gemacht...");
	}

	@Override
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§7Das System wird nun geladen...");
	}
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cSystem fährt herunter...");
	}
}
