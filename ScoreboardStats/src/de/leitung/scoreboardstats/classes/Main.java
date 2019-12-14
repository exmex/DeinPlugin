package de.leitung.scoreboardstats.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("§aScoreboardStats - Das Plugin wird geladen...");
	}
	public void loadConfig(){
		File file = new File("plugins//Scorebord//stats.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get("Contais.YML") == null){
			cfg.set("Contais.YML", true);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Config Exists!");
		}
	}
}
