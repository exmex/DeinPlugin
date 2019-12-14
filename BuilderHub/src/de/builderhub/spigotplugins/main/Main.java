package de.builderhub.spigotplugins.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

public class Main extends JavaPlugin{
	
	public static String Prefix = "§7| §3BauServer §7» ";
	public static int lobbyPlayers;
	public static int teamPlayers;
	public static int fortPlayers;
	public static int gastPlayers;
	public static int cd;
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Prefix + "§eDas System startet...");
		Bukkit.getPluginManager().registerEvents(new Join(), this);
		cd = 5;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				cd--;
				if(cd == 0){
				for(Player all : Bukkit.getOnlinePlayers()){
					Scoreboard.setScoreboard(all);
				}
				cd = 5;
				}
			}
		}, 20, 20);
	}

}
