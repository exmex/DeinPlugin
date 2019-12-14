package de.souppvp.levelsystem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.souppvp.statssystem.StatsSystem;

public class LevelData {

	public static HashMap<String, Integer> Level = new HashMap<>();
	public static File file = new File("plugins//SoupPvP//level.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	public static void createLevel(){
		File file = new File("plugins//SoupPvP//level.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get("Level") == null){
			cfg.set("Level", true);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String getLevel(Player p){
		String Level = "";
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > -1 && StatsSystem.kills.get(p.getUniqueId().toString()) < 20){
			Level = "§71";
			LevelData.Level.put(p.getName(), 1);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 19 && StatsSystem.kills.get(p.getUniqueId().toString()) < 40){
			Level = "§72";
			LevelData.Level.put(p.getName(), 2);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 39 && StatsSystem.kills.get(p.getUniqueId().toString()) < 60){
			Level = "§73";
			LevelData.Level.put(p.getName(), 3);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 59 && StatsSystem.kills.get(p.getUniqueId().toString()) < 80){
			Level = "§74";
			LevelData.Level.put(p.getName(), 4);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 79 && StatsSystem.kills.get(p.getUniqueId().toString()) < 100){
			Level = "§b5";
			LevelData.Level.put(p.getName(), 5);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 99 && StatsSystem.kills.get(p.getUniqueId().toString()) < 120){
			Level = "§b6";
			LevelData.Level.put(p.getName(), 6);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 119 && StatsSystem.kills.get(p.getUniqueId().toString()) < 140){
			Level = "§b7";
			LevelData.Level.put(p.getName(), 7);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 139 && StatsSystem.kills.get(p.getUniqueId().toString()) < 160){
			Level = "§b8";
			LevelData.Level.put(p.getName(), 8);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 159 && StatsSystem.kills.get(p.getUniqueId().toString()) < 180){
			Level = "§b9";
			LevelData.Level.put(p.getName(), 9);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 179 && StatsSystem.kills.get(p.getUniqueId().toString()) < 200){
			Level = "§d10";
			LevelData.Level.put(p.getName(), 10);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 199 && StatsSystem.kills.get(p.getUniqueId().toString()) < 220){
			Level = "§d11";
			LevelData.Level.put(p.getName(), 11);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 219 && StatsSystem.kills.get(p.getUniqueId().toString()) < 240){
			Level = "§d12";
			LevelData.Level.put(p.getName(), 12);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 239 && StatsSystem.kills.get(p.getUniqueId().toString()) < 260){
			Level = "§d13";
			LevelData.Level.put(p.getName(), 13);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 259 && StatsSystem.kills.get(p.getUniqueId().toString()) < 280){
			Level = "§d14";
			LevelData.Level.put(p.getName(), 14);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 279 && StatsSystem.kills.get(p.getUniqueId().toString()) < 300){
			Level = "§d15";
			LevelData.Level.put(p.getName(), 15);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 299 && StatsSystem.kills.get(p.getUniqueId().toString()) < 320){
			Level = "§e16";
			LevelData.Level.put(p.getName(), 16);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 319 && StatsSystem.kills.get(p.getUniqueId().toString()) < 340){
			Level = "§f17";
			LevelData.Level.put(p.getName(), 17);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 339 && StatsSystem.kills.get(p.getUniqueId().toString()) < 360){
			Level = "§f18";
			LevelData.Level.put(p.getName(), 18);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 359 && StatsSystem.kills.get(p.getUniqueId().toString()) < 380){
			Level = "§f19";
			LevelData.Level.put(p.getName(), 19);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 379 && StatsSystem.kills.get(p.getUniqueId().toString()) < 400){
			Level = "§f20";
			LevelData.Level.put(p.getName(), 20);
		}
		return Level;
	}
	public static int getLevelToINT(Player p){
		int Level = 0;
		System.out.print("Kills: " + StatsSystem.kills.get(p.getUniqueId().toString()));
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > -1 && StatsSystem.kills.get(p.getUniqueId().toString()) < 20){
			Level = 1;
			LevelData.Level.put(p.getName(), 1);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 19 && StatsSystem.kills.get(p.getUniqueId().toString()) < 40){
			Level = 2;
			LevelData.Level.put(p.getName(), 2);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 39 && StatsSystem.kills.get(p.getUniqueId().toString()) < 60){
			Level = 3;
			LevelData.Level.put(p.getName(), 3);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 59 && StatsSystem.kills.get(p.getUniqueId().toString()) < 80){
			Level = 4;
			LevelData.Level.put(p.getName(), 4);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 79 && StatsSystem.kills.get(p.getUniqueId().toString()) < 100){
			Level = 5;
			LevelData.Level.put(p.getName(), 5);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 99 && StatsSystem.kills.get(p.getUniqueId().toString()) < 120){
			Level = 6;
			LevelData.Level.put(p.getName(), 6);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 119 && StatsSystem.kills.get(p.getUniqueId().toString()) < 140){
			Level = 7;
			LevelData.Level.put(p.getName(), 7);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 139 && StatsSystem.kills.get(p.getUniqueId().toString()) < 160){
			Level = 8;
			LevelData.Level.put(p.getName(), 8);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 159 && StatsSystem.kills.get(p.getUniqueId().toString()) < 180){
			Level = 9;
			LevelData.Level.put(p.getName(), 9);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 179 && StatsSystem.kills.get(p.getUniqueId().toString()) < 200){
			Level = 10;
			LevelData.Level.put(p.getName(), 10);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 179 && StatsSystem.kills.get(p.getUniqueId().toString()) < 200){
			Level = 10;
			LevelData.Level.put(p.getName(), 10);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 199 && StatsSystem.kills.get(p.getUniqueId().toString()) < 220){
			Level = 11;
			LevelData.Level.put(p.getName(), 11);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 219 && StatsSystem.kills.get(p.getUniqueId().toString()) < 240){
			Level = 12;
			LevelData.Level.put(p.getName(), 12);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 239 && StatsSystem.kills.get(p.getUniqueId().toString()) < 260){
			Level = 13;
			LevelData.Level.put(p.getName(), 13);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 259 && StatsSystem.kills.get(p.getUniqueId().toString()) < 280){
			Level = 14;
			LevelData.Level.put(p.getName(), 14);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 279 && StatsSystem.kills.get(p.getUniqueId().toString()) < 300){
			Level = 15;
			LevelData.Level.put(p.getName(), 15);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 299 && StatsSystem.kills.get(p.getUniqueId().toString()) < 320){
			Level = 16;
			LevelData.Level.put(p.getName(), 16);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 319 && StatsSystem.kills.get(p.getUniqueId().toString()) < 340){
			Level = 17;
			LevelData.Level.put(p.getName(), 17);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 339 && StatsSystem.kills.get(p.getUniqueId().toString()) < 360){
			Level = 18;
			LevelData.Level.put(p.getName(), 18);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 359 && StatsSystem.kills.get(p.getUniqueId().toString()) < 380){
			Level = 19;
			LevelData.Level.put(p.getName(), 19);
		}
		if(StatsSystem.kills.get(p.getUniqueId().toString()) > 379 && StatsSystem.kills.get(p.getUniqueId().toString()) < 400){
			Level = 20;
			LevelData.Level.put(p.getName(), 20);
		}
		return Level;
	}
}
	
