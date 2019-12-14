package spigotplugins.skywars.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class DeathListener implements Listener{
	public static int endingTime;
	public static ArrayList<Player> INGAME = new ArrayList<>();
	public DeathListener(spigotplugins.skywars.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.skywars.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(Data.gs == GameState.LOBBY){
			e.setDeathMessage(null);
			Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
				
				@Override
				public void run() {
					e.getEntity().teleport(Data.Locs.get("Spawn"));
				}
			}, 10L);
			return;
		}
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		
		for(Player all : Bukkit.getOnlinePlayers()){
			all.hidePlayer(p);
		}
		p.setHealth(20);
		p.setGameMode(GameMode.SPECTATOR);		
		p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 10, 10);
		e.setDeathMessage(null);
		
		if(Data.gs == GameState.INGAME){
			if(Data.runmovecountdown == false){
				if(k != null){
					Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
						
						@Override
						public void run() {
							e.getEntity().getKiller().sendMessage(Data.Prefix + "§7[§a+§7] §610 §5SkyWars§7-§eCoins");
							new Manager().addInt(p.getUniqueId(), p.getName(), "SKYWARS", "DEATHS", 1);
							new Manager().addInt(k.getUniqueId(), k.getName(), "SKYWARS", "KILLS", 1);
							new Manager().addInt(k.getUniqueId(), k.getName(), "SKYWARS", "COINS", 3);
							StatsManager.Coins.put(p.getName(), StatsManager.Coins.get(p.getName()) +10);
						}
					},1L);
					e.setDeathMessage(Data.Prefix + "§9" + p.getName() + "§e wurde von §c" + k.getName() + "§e getötet!");	
					for(Player all : Bukkit.getOnlinePlayers()){
						all.playSound(all.getLocation(), Sound.BAT_TAKEOFF, 10, 10);
					}
				}else{
						Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
						
						@Override
						public void run() {
							new Manager().addInt(p.getUniqueId(), p.getName(), "SKYWARS", "DEATHS", 1);
						}
					},1L);
					e.setDeathMessage(Data.Prefix + "§9" + p.getName() + "§e ist gestorben!");
					for(Player all : Bukkit.getOnlinePlayers()){
						all.playSound(all.getLocation(), Sound.BAT_TAKEOFF, 10, 10);
					}
				}
					DeathListener.INGAME.remove(p);
				
				for(Player all : Bukkit.getOnlinePlayers()){
					all.playSound(all.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
				}
				if(DeathListener.INGAME.size() == 1){
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
						@Override
						public void run() {
							String winner = null;
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.ENDERMAN_SCREAM, 10, 10);
								if(DeathListener.INGAME.contains(all)){
									winner = all.getName();
								}
							}
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage(Data.Prefix + "§9Der Spieler §6§l" + winner + "§9 hat das Spiel gewonnen!");
							Bukkit.broadcastMessage("");
							Player win = Bukkit.getPlayer(winner);
							if(win != null){
								new Manager().addInt(p.getUniqueId(), p.getName(), "SKYWARS", "WINS", 1);
							}
							for(Player all : Bukkit.getOnlinePlayers()){
								all.setHealth(20);
								all.setFoodLevel(20);
								all.getInventory().clear();
								all.getInventory().setArmorContents(null);
								
							}
							
						}
					},6L);
					for(Player all : Bukkit.getOnlinePlayers()){
					all.setGameMode(GameMode.ADVENTURE);
					Boards.setBoard(all);
					all.teleport(Data.Locs.get("Spawn"));
					}
					Data.gs = GameState.ENDING;
					Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
						
						@Override
						public void run() {
							if(endingTime == 15){
								((CraftServer) Bukkit.getServer()).getServer().setMotd("ENDING");
								for(Player all : Bukkit.getOnlinePlayers()){
									for(Player all1 : Bukkit.getOnlinePlayers()){
										all.showPlayer(all1);
									}
								}
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §615 §cSekunden neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							endingTime--;
							if(endingTime == 10){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + endingTime + " §cSekunden neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							if(endingTime == 5){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + endingTime + " §cSekunden neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							if(endingTime == 4){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + endingTime + " §cSekunden neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							if(endingTime == 3){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + endingTime + " §cSekunden neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							if(endingTime == 2){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + endingTime + " §cSekunden neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							if(endingTime == 1){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6einer §cSekunde neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								}
							}
							if(endingTime == 0){
								Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet neu!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
									all.kickPlayer(Data.Prefix + "§cDer Server startet neu...");
									Bukkit.shutdown();
								}
							}
						}
					}, 20, 20);

				}
				}
				}else{
				p.kickPlayer("§cEs ist ein Fehler aufgetreten!");
			}
		Bukkit.broadcastMessage("");
		Bukkit.broadcastMessage(Data.Prefix + "§9Es verbleiben noch §6" + DeathListener.INGAME.size() + "§9 Spieler!");
		Bukkit.broadcastMessage("");
	}
	
	
	}
	
