package bedwars.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import bedwars.gamestate.GameState;


public class Main extends JavaPlugin{
	public static GameState gs = GameState.LOBBY;
	
		public void onEnable(){
			gs = GameState.LOBBY;
			Bukkit.broadcastMessage("§bBedWars §7> §6Das Plugin wird aktuell gestartet!");
		}

}
