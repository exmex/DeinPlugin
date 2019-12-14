package de.ttt.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.ttt.commands.StartCMD;
import de.ttt.game.JoinManager;
import de.ttt.game.MainListener;
import de.ttt.game.QuitMessage;
import de.ttt.gamestates.GameState;
import de.ttt.manager.TeamManager;
import de.ttt.utils.Data;

public class Main extends JavaPlugin{

	public static GameState gs;
	public static int cd;
	public static int waitForPlayer;
	@SuppressWarnings("deprecation")
	public void onEnable() {
		
		new MainListener(this).gamestarted = false;
		getCommand("start").setExecutor(new StartCMD());
		waitForPlayer = 10;
		gs = GameState.LOBBY;
		Bukkit.getConsoleSender().sendMessage("§3Das TTT Plugin wird gestartet!");
		loadCommands();
		loadEvents();
		cd = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				waitForPlayer--;
				if(Bukkit.getOnlinePlayers().size() < 2){
					if(Main.gs == GameState.LOBBY){
						if(waitForPlayer == 0){
						Bukkit.broadcastMessage(Data.prefix + "§3Warte auf weitere Spieler...");
						waitForPlayer = 10;
						}
						}else{
						Bukkit.getScheduler().cancelTask(cd);
					
				
					}
				}
			}
		}, 20, 20);
	}
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("§cDas TTT Plugin wird gestoppt!");

	}
	public void loadEvents(){
		Bukkit.getPluginManager().registerEvents(new JoinManager(), this);
		Bukkit.getPluginManager().registerEvents(new MainListener(this), this);
		Bukkit.getPluginManager().registerEvents(new QuitMessage(), this);
		Bukkit.getPluginManager().registerEvents(new TeamManager(), this);

	}
	public void loadCommands(){
		getCommand("setspawn").setExecutor(new SpawnManager());
	}
}
