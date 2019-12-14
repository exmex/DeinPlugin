package de.skywars.main;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scoreboard.Score;

import de.skywars.gamestates.GameState;
import de.skywars.methods.SpawnManager;
import de.skywars.utils.CoinsManager;
import de.skywars.utils.Data;
import de.skywars.utils.Scoreboard;
import de.skywars.utils.StatsManager;

public class DeathListener implements Listener{
	public static HashMap<Player, Integer> roundkills = new HashMap<Player, Integer>();
	public DeathListener(de.skywars.main.Main Main){
		this.pl = Main;
	}
	private static de.skywars.main.Main pl;
	int i;
	int cd;
	int cd2;
	int cd7;
	int cdc;
	static String Winner;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player pa = e.getEntity();
		Player k = pa.getKiller();

		for(Player all : Bukkit.getOnlinePlayers()){
			all.hidePlayer(pa);
		}
		MainListener.players.remove(e.getEntity());
		cdc = 12;
		i = 0;
		e.setDeathMessage(" ");
		if(k == null){
			StatsManager.addCurrentTode(pa, 1);
			e.getEntity().setGameMode(GameMode.SPECTATOR);
			e.setDeathMessage(Data.Prefix + "§6" + e.getEntity().getName() + "§e ist gestorben!");
			
		}else{
			StatsManager.addCurrentKills(k, 1);
			roundkills.put(k, roundkills.get(k) +1);
			e.getEntity().getKiller().playSound(e.getEntity().getKiller().getLocation(), Sound.NOTE_PLING, 1, 1);
			e.setDeathMessage(Data.Prefix + "§6" + e.getEntity().getName() + "§e wurde von §6" + e.getEntity().getKiller().getName() + "§e getötet!");
		}
		
		cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
			
			@Override
			public void run() {
				e.getEntity().spigot().respawn();
				Bukkit.getScheduler().cancelTask(cd);
				e.getEntity().setGameMode(GameMode.SPECTATOR);

			}
		}, 20, 4);
		if(e.getEntity().getKiller() != null){
		e.getEntity().teleport(e.getEntity().getKiller().getLocation());
		e.getEntity().setGameMode(GameMode.SPECTATOR);

		}

		if(MainListener.players.size() == 1){
			Player p = MainListener.players.get(0);
			if(Bukkit.getScheduler().isCurrentlyRunning(cd7)){
				Bukkit.getScheduler().cancelTask(cd7);
			}
			cd7 = Bukkit.getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {
				
				@Override
				public void run() {
					Bukkit.broadcastMessage(Data.Prefix + "§6Der Spieler §e" + p.getName() + "§6 hat die SkyWars-Runde §agewonnen§6!");
					Bukkit.getScheduler().cancelTask(cd7);
				}
			}, 20, 10);
		Main.gs = GameState.ENDING;
		for(Player all : Bukkit.getOnlinePlayers()){
			SpawnManager.teleportToSpawn(all);
			all.setGameMode(GameMode.SURVIVAL);
			all.getInventory().clear();
			all.setHealth(20);
			all.setFoodLevel(20);
			all.getInventory().setArmorContents(null);
		}
			cd2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
				@Override
				public void run() {
					cdc--;					
					if(cdc == 10){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §610 §eSekunden neu!");
						Main.chestuse = false;
						for(Player all : Bukkit.getOnlinePlayers()){
							SpawnManager.teleportToSpawn(all);
							Scoreboard.setScoreboard(all);
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
							
							@Override
							public void run() {
								for(Player all : Bukkit.getOnlinePlayers()){
								Scoreboard.setScoreboard(all);	
								}
							}
						}, 20L);
						
					}
					if(cdc == 9){
						for(Player all : Bukkit.getOnlinePlayers()) {
						all.setGameMode(GameMode.SURVIVAL);
						all.getInventory().clear();
						all.setHealth(20);
						all.setFoodLevel(20);
						}
					}
					if(cdc == 5){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §65 §eSekunden neu!");
					}
					if(cdc == 4){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §64 §eSekunden neu!");
					}
					if(cdc == 3){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §63 §eSekunden neu!");
					}
					if(cdc == 2){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §62 §eSekunden neu!");
					}
					if(cdc == 1){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §61 §eSekunden neu!");
					}
					if(cdc == 0){
						
				
						for(Player all : Bukkit.getOnlinePlayers()){
						StatsManager.InsertStatsIntoMySQL(all);
						CoinsManager.loadHashCoinsIntoSQL(all);
						}
						World w = Main.resetWorld(new File("backup_" + Main.MapName) , new File(Main.MapName) , Main.MapName);
						Bukkit.shutdown();
						
					}
					
				}
			}, 20, 20);
		}
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
		Bukkit.broadcastMessage(Data.Prefix + "§eEs verbleiben noch §3" + MainListener.players.size() + "§e Spieler!");
	}

	@EventHandler
	public void onRe(PlayerRespawnEvent e){
		e.getPlayer().setGameMode(GameMode.SPECTATOR);
		if(e.getPlayer().getKiller() != null){
			
		e.setRespawnLocation(e.getPlayer().getKiller().getLocation());
		MainListener.players.remove(e.getPlayer());
	}
	}
	
	 @EventHandler
	 public void onMove(PlayerMoveEvent e){
		 if(e.getPlayer().getLocation().getY() < 0){
			 e.getPlayer().damage(20.0);
			 Location loc = e.getPlayer().getLocation();
			 loc.setY(100);
			 e.getPlayer().teleport(loc);
		 }
	 }
	 @EventHandler
	 public void onItem(PlayerPickupItemEvent e){
		 if(Main.gs == GameState.INGAME){
		 if(MainListener.players.contains(e.getPlayer())){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onDr(PlayerDropItemEvent e){
		 if(Main.gs == GameState.INGAME){
			 if(MainListener.players.contains(e.getPlayer())){
				 e.setCancelled(false);
			 }else{
				 e.setCancelled(true);
			 }
		 }else{
			 e.setCancelled(true);
		 }
	 }
}
