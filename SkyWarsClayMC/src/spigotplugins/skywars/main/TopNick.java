package spigotplugins.skywars.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import me.eder.statsapi.manager.Manager;

public class TopNick {
	public ArrayList<String> TOP = new ArrayList<>();
	public ArrayList<String> TOPACTUALINDATABASE = new ArrayList<>();
	public ArrayList<String> TOPLISTINSERT = new ArrayList<>();

	public File file = new File("plugins//SkyWars//Nick.yml");
	public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	public void loadActualTopNick(){
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 String One = new Manager().getNameRankByID("SKYWARS", "KILLS", 1);
			 String Two = new Manager().getNameRankByID("SKYWARS", "KILLS", 2);
			 String Three = new Manager().getNameRankByID("SKYWARS", "KILLS", 3);
			 String Four = new Manager().getNameRankByID("SKYWARS", "KILLS", 4);
			 String Fife = new Manager().getNameRankByID("SKYWARS", "KILLS", 5);
			 TOPACTUALINDATABASE.add(One);
			 TOPACTUALINDATABASE.add(Two);
			 TOPACTUALINDATABASE.add(Three);
			 TOPACTUALINDATABASE.add(Four);
			 TOPACTUALINDATABASE.add(Fife);
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + One + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Two + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Three + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Four + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Fife + " add claymc.nick");
			 cfg.set("TOP", TOPACTUALINDATABASE);
			 try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 TOP = (ArrayList<String>) cfg.getStringList("TOP");
		 String One = new Manager().getNameRankByID("SKYWARS", "KILLS", 1);
		 String Two = new Manager().getNameRankByID("SKYWARS", "KILLS", 2);
		 String Three = new Manager().getNameRankByID("SKYWARS", "KILLS", 3);
		 String Four = new Manager().getNameRankByID("SKYWARS", "KILLS", 4);
		 String Fife = new Manager().getNameRankByID("SKYWARS", "KILLS", 5);
		 TOPACTUALINDATABASE.add(One);
		 TOPACTUALINDATABASE.add(Two);
		 TOPACTUALINDATABASE.add(Three);
		 TOPACTUALINDATABASE.add(Four);
		 TOPACTUALINDATABASE.add(Fife);
		 
		 String ConfigOne = TOP.get(0);
		 String ConfigTwo = TOP.get(1);
		 String ConfigThree = TOP.get(2);
		 String ConfigFour = TOP.get(3);
		 String ConfigFife = TOP.get(4);

		
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + ConfigOne + " remove claymc.nick");
		 
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + ConfigTwo + " remove claymc.nick");
		 
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + ConfigThree + " remove claymc.nick");
		 
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + ConfigFour + " remove claymc.nick");
		 
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + ConfigFife + " remove claymc.nick");
		 
		
		 TOPLISTINSERT.add(One);
		 TOPLISTINSERT.add(Two);
		 TOPLISTINSERT.add(Three);
		 TOPLISTINSERT.add(Four);
		 TOPLISTINSERT.add(Fife);

		 cfg.set("TOP", TOPLISTINSERT);
		 try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	

			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + One + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Two + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Three + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Four + " add claymc.nick");
			 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + Fife + " add claymc.nick");

	}
	
}
