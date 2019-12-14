package oneline.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import oneline.data.Data;
import oneline.methods.Board;
import oneline.methods.Inventory;
import oneline.methods.Score;
import oneline.methods.SpawnManager;

public class JoinListener implements Listener{
	public static int i;
	
	public JoinListener(oneline.main.Main Main){
		this.pl = Main;
	}
	private oneline.main.Main pl;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Player all : Bukkit.getOnlinePlayers()){
			Score.setScoreboard(all);
		}
		Board.setBoard(p);
		p.setFoodLevel(20);
		p.setHealth(20);
		Inventory.getNormalInventory(p);
		if(Bukkit.getOnlinePlayers().size() < 10){
			e.setJoinMessage(Data.Prefix + "§eDer Spieler §9" + e.getPlayer().getName() + "§e spielt nun mit!");			
		}else{
			e.setJoinMessage(null);
		}
		
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			@Override
			public void run() {
				teleportPlayerRandom(p);
			}
		},3);
		
	}
	
	public static void teleportPlayerRandom(Player p){
			i++;
			if(i == 6){
				i = 1;
			}
			p.teleport(SpawnManager.mainLocations.get("S" + i));
			return;
	}
	@EventHandler
	public void onE(EntityDamageByEntityEvent e){
		if(e.getEntity().getLocation().getY() > 15 && e.getEntity().getLocation().getY() < 26){
			e.setCancelled(true);
		}
		if(e.getDamager().getLocation().getY() > 15 && e.getDamager().getLocation().getY() < 26){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
}
