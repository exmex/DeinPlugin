package souppvp.manager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class LevelManager{

	
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
		if(StatsManager.kills.get(p.getUniqueId().toString()) > -1 && StatsManager.kills.get(p.getUniqueId().toString()) < 20){
			Level = "§71";
			LevelManager.Level.put(p.getName(), 1);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 19 && StatsManager.kills.get(p.getUniqueId().toString()) < 40){
			Level = "§72";
			LevelManager.Level.put(p.getName(), 2);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 39 && StatsManager.kills.get(p.getUniqueId().toString()) < 60){
			Level = "§73";
			LevelManager.Level.put(p.getName(), 3);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 59 && StatsManager.kills.get(p.getUniqueId().toString()) < 80){
			Level = "§74";
			LevelManager.Level.put(p.getName(), 4);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 79 && StatsManager.kills.get(p.getUniqueId().toString()) < 100){
			Level = "§b5";
			LevelManager.Level.put(p.getName(), 5);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 99 && StatsManager.kills.get(p.getUniqueId().toString()) < 120){
			Level = "§b6";
			LevelManager.Level.put(p.getName(), 6);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 119 && StatsManager.kills.get(p.getUniqueId().toString()) < 140){
			Level = "§b7";
			LevelManager.Level.put(p.getName(), 7);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 139 && StatsManager.kills.get(p.getUniqueId().toString()) < 160){
			Level = "§b8";
			LevelManager.Level.put(p.getName(), 8);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 159 && StatsManager.kills.get(p.getUniqueId().toString()) < 180){
			Level = "§b9";
			LevelManager.Level.put(p.getName(), 9);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 179 && StatsManager.kills.get(p.getUniqueId().toString()) < 200){
			Level = "§d10";
			LevelManager.Level.put(p.getName(), 10);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 199 && StatsManager.kills.get(p.getUniqueId().toString()) < 220){
			Level = "§d11";
			LevelManager.Level.put(p.getName(), 11);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 219 && StatsManager.kills.get(p.getUniqueId().toString()) < 240){
			Level = "§d12";
			LevelManager.Level.put(p.getName(), 12);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 239 && StatsManager.kills.get(p.getUniqueId().toString()) < 260){
			Level = "§d13";
			LevelManager.Level.put(p.getName(), 13);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 259 && StatsManager.kills.get(p.getUniqueId().toString()) < 280){
			Level = "§d14";
			LevelManager.Level.put(p.getName(), 14);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 279 && StatsManager.kills.get(p.getUniqueId().toString()) < 300){
			Level = "§d15";
			LevelManager.Level.put(p.getName(), 15);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 299 && StatsManager.kills.get(p.getUniqueId().toString()) < 320){
			Level = "§e16";
			LevelManager.Level.put(p.getName(), 16);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 319 && StatsManager.kills.get(p.getUniqueId().toString()) < 340){
			Level = "§f17";
			LevelManager.Level.put(p.getName(), 17);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 339 && StatsManager.kills.get(p.getUniqueId().toString()) < 360){
			Level = "§f18";
			LevelManager.Level.put(p.getName(), 18);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 359 && StatsManager.kills.get(p.getUniqueId().toString()) < 380){
			Level = "§f19";
			LevelManager.Level.put(p.getName(), 19);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 379 && StatsManager.kills.get(p.getUniqueId().toString()) < 400){
			Level = "§f20";
			LevelManager.Level.put(p.getName(), 20);
		}
		return Level;
	}
	public static int getLevelToINT(Player p){
		int Level = 0;
		System.out.print("Kills: " + StatsManager.kills.get(p.getUniqueId().toString()));
		if(StatsManager.kills.get(p.getUniqueId().toString()) > -1 && StatsManager.kills.get(p.getUniqueId().toString()) < 20){
			Level = 1;
			LevelManager.Level.put(p.getName(), 1);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 19 && StatsManager.kills.get(p.getUniqueId().toString()) < 40){
			Level = 2;
			LevelManager.Level.put(p.getName(), 2);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 39 && StatsManager.kills.get(p.getUniqueId().toString()) < 60){
			Level = 3;
			LevelManager.Level.put(p.getName(), 3);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 59 && StatsManager.kills.get(p.getUniqueId().toString()) < 80){
			Level = 4;
			LevelManager.Level.put(p.getName(), 4);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 79 && StatsManager.kills.get(p.getUniqueId().toString()) < 100){
			Level = 5;
			LevelManager.Level.put(p.getName(), 5);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 99 && StatsManager.kills.get(p.getUniqueId().toString()) < 120){
			Level = 6;
			LevelManager.Level.put(p.getName(), 6);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 119 && StatsManager.kills.get(p.getUniqueId().toString()) < 140){
			Level = 7;
			LevelManager.Level.put(p.getName(), 7);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 139 && StatsManager.kills.get(p.getUniqueId().toString()) < 160){
			Level = 8;
			LevelManager.Level.put(p.getName(), 8);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 159 && StatsManager.kills.get(p.getUniqueId().toString()) < 180){
			Level = 9;
			LevelManager.Level.put(p.getName(), 9);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 179 && StatsManager.kills.get(p.getUniqueId().toString()) < 200){
			Level = 10;
			LevelManager.Level.put(p.getName(), 10);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 179 && StatsManager.kills.get(p.getUniqueId().toString()) < 200){
			Level = 10;
			LevelManager.Level.put(p.getName(), 10);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 199 && StatsManager.kills.get(p.getUniqueId().toString()) < 220){
			Level = 11;
			LevelManager.Level.put(p.getName(), 11);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 219 && StatsManager.kills.get(p.getUniqueId().toString()) < 240){
			Level = 12;
			LevelManager.Level.put(p.getName(), 12);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 239 && StatsManager.kills.get(p.getUniqueId().toString()) < 260){
			Level = 13;
			LevelManager.Level.put(p.getName(), 13);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 259 && StatsManager.kills.get(p.getUniqueId().toString()) < 280){
			Level = 14;
			LevelManager.Level.put(p.getName(), 14);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 279 && StatsManager.kills.get(p.getUniqueId().toString()) < 300){
			Level = 15;
			LevelManager.Level.put(p.getName(), 15);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 299 && StatsManager.kills.get(p.getUniqueId().toString()) < 320){
			Level = 16;
			LevelManager.Level.put(p.getName(), 16);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 319 && StatsManager.kills.get(p.getUniqueId().toString()) < 340){
			Level = 17;
			LevelManager.Level.put(p.getName(), 17);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 339 && StatsManager.kills.get(p.getUniqueId().toString()) < 360){
			Level = 18;
			LevelManager.Level.put(p.getName(), 18);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 359 && StatsManager.kills.get(p.getUniqueId().toString()) < 380){
			Level = 19;
			LevelManager.Level.put(p.getName(), 19);
		}
		if(StatsManager.kills.get(p.getUniqueId().toString()) > 379 && StatsManager.kills.get(p.getUniqueId().toString()) < 400){
			Level = 20;
			LevelManager.Level.put(p.getName(), 20);
		}
		return Level;
	}
	
}
