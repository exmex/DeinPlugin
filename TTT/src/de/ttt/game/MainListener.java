package de.ttt.game;

import java.time.temporal.TemporalAmount;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.ttt.gamestates.GameState;
import de.ttt.main.Main;
import de.ttt.manager.TeamManager;
import de.ttt.utils.Data;

public class MainListener implements Listener{
	
	public MainListener(de.ttt.main.Main Main){
		this.pl = Main;
	}
	private de.ttt.main.Main pl;
	public boolean gamestarted;
	static int cd;
	public static int cdz;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if(Main.gs == GameState.LOBBY){
			Player p = e.getPlayer();
			e.setJoinMessage(Data.prefix + "§6Der Spieler §e" + p.getName() + "§6 hat das Spiel betreten!");
			
			if(Bukkit.getOnlinePlayers().size() > 0){
				cdz = 61;
				if(gamestarted == false){
					Bukkit.broadcastMessage(Data.prefix + "§eEs sind genügend Spieler Online! Daraufhin startet das Spiel nun!");
					gamestarted = true;
				}
				
				cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
					
					@Override
					public void run() {
						cdz--;
						if(cdz == 60){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz == 50){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz == 40){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz == 30){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz == 20){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz == 10){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz < 5 && cdz > 1){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6" + cdz + "§e Sekunden!");
						}
						if(cdz == 1){
							Bukkit.broadcastMessage(Data.prefix + "§eDas Spiel beginnt in §6einer§e Sekunde!");
							
							Bukkit.getScheduler().cancelTask(cd);
							Main.gs = GameState.INGAME;
							
							for(Player all : Bukkit.getOnlinePlayers()){
								if(!TeamManager.detective.contains(all) || !TeamManager.traitor.contains(all)){
									TeamManager.pickRandomTeams(all);
								}
							}
							
						}
						
						
					}
				}, 20, 20);				
			}
			
			
			
		}
		
		
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(Bukkit.getOnlinePlayers().size() == 2){
			if(Main.gs == GameState.LOBBY){
				if(Bukkit.getScheduler().isCurrentlyRunning(cd)){
					Bukkit.getScheduler().cancelTask(cd);
					Bukkit.broadcastMessage(Data.prefix + "§cEs sind zu wenige Spieler online, damit der Countdown weiterlaufen kann!");
					cdz = 61;
				}
			}
		}
	}
}
