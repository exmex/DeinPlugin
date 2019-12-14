package spigotplugins.skywars.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import NickSystem.Manager.AutoNickManager;
import NickSystem.Manager.NickManager;
import NickSystem.Manager.NickNameManager;
import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.storage.GameState;
import spigotplugins.skywars.main.Boards;
import spigotplugins.skywars.main.DeathListener;
import spigotplugins.skywars.main.Main;
import spigotplugins.skywars.manager.StartCMD;
import spigotplugins.skywars.storage.Data;

public class QuitListener implements Listener{
	public QuitListener(spigotplugins.skywars.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.skywars.main.Main pl;
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		if(Data.gs == GameState.ENDING){
			if(Bukkit.getOnlinePlayers().size() == 1){
				Bukkit.shutdown();
			}
		}
		if(!DeathListener.INGAME.contains(e.getPlayer())){
			e.setQuitMessage(null);
			return;
		}
		if(Data.gs == GameState.INGAME || Data.gs == GameState.ENDING){
			e.setQuitMessage(Data.Prefix + "§cDer Spieler §e" + e.getPlayer().getName() + "§c hat das Spiel verlassen!");
			DeathListener.INGAME.remove(e.getPlayer());
			if(Data.gs != GameState.ENDING){
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(Data.Prefix + "§9Es verbleiben noch §6" + DeathListener.INGAME.size() + "§9 Spieler!");
			Bukkit.broadcastMessage("");
			}
			if(Bukkit.getOnlinePlayers().size() == 1){
				Bukkit.shutdown();
			}
		}
		if(Data.gs == GameState.LOBBY){
			e.setQuitMessage(Data.Prefix + "§eDer Spieler §6" + e.getPlayer().getName() + "§e hat die Runde §cverlassen§e!");
			if(Data.runlobbycountdown){
				Data.runlobbycountdown = false;
				Main.wartezeit = 60;
				StartCMD.started = false;
			}
		}
		if(Data.gs == GameState.INGAME){
			DeathListener.INGAME.remove(e.getPlayer());
			if(DeathListener.INGAME.size() == 1){
				Data.gs = GameState.ENDING;
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
				if(Bukkit.getOnlinePlayers().size() == 1 || Bukkit.getOnlinePlayers().size() == 0){
					Bukkit.shutdown();
				}
				for(Player all : Bukkit.getOnlinePlayers()){
					all.teleport(Data.Locs.get("Spawn"));
					all.setHealth(20);
					all.setFoodLevel(20);
					all.getInventory().clear();
					all.getInventory().setArmorContents(null);
					
				}
				
			
			for(Player all : Bukkit.getOnlinePlayers()){
				for(Player all1 : Bukkit.getOnlinePlayers()){
					all.showPlayer(all1);
				}
			}
			for(Player all : Bukkit.getOnlinePlayers()){
				all.setGameMode(GameMode.ADVENTURE);
				Boards.setBoard(all);
				}
				Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
					
					@Override
					public void run() {
						
						if(DeathListener.endingTime == 15){
							((CraftServer) Bukkit.getServer()).getServer().setMotd("ENDING");
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §615 §cSekunden neu!");
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
								all.setGameMode(GameMode.ADVENTURE);
							}
						}
						DeathListener.endingTime--;
						if(DeathListener.endingTime == 10){
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + DeathListener.endingTime + " §cSekunden neu!");
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
							}
						}
						if(DeathListener.endingTime == 5){
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + DeathListener.endingTime + " §cSekunden neu!");
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
							}
						}
						if(DeathListener.endingTime == 4){
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + DeathListener.endingTime + " §cSekunden neu!");
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
							}
						}
						if(DeathListener.endingTime == 3){
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + DeathListener.endingTime + " §cSekunden neu!");
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
							}
						}
						if(DeathListener.endingTime == 2){
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6" + DeathListener.endingTime + " §cSekunden neu!");
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
							}
						}
						if(DeathListener.endingTime == 1){
							Bukkit.broadcastMessage(Data.Prefix + "§cDer Server startet in §6einer §cSekunde neu!");
							Bukkit.shutdown();
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 6, 6);
							}
						}
						if(DeathListener.endingTime == 0){
							Bukkit.shutdown();
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
			}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getType() == Material.SLIME_BALL){
					if(Data.gs == GameState.LOBBY){
						e.getPlayer().kickPlayer(Data.Prefix + "§cDu hast die Runde verlassen!");
					}
				}
				
			}
		}catch(Exception e1){}

	}
}